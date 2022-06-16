package ru.live4code.blog.api.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.live4code.blog.api.dao.implementation.NewsDAOImpl;
import ru.live4code.blog.api.dao.repository.NewsRepository;
import ru.live4code.blog.api.dao.repository.UserRepository;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.user.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NewsDAOTest {

    private static long USER_ID = 1L;
    private static long NEWS_ID = 1L;

    @Mock
    private NewsRepository newsRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private NewsDAO underTest = new NewsDAOImpl();

    @Test
    void itShouldCreateNews() {

        //given
        News news = new News();
        news.setTitle("Test title");
        news.setText("Hello world!");

        User user = new User();
        user.setId(USER_ID);
        user.setSurname("Vedenin");
        user.setName("Ivan");
        user.setEmail("steven.marelly@gmail.com");
        user.setUsername("live4code");
        user.setPassword("SimplePassword");

        given(userRepository.findById(USER_ID)).willReturn(java.util.Optional.of(user));

        //when
        underTest.create(news, 1L);

        //then
        ArgumentCaptor<News> newsArgumentCaptor = ArgumentCaptor.forClass(News.class);
        verify(newsRepository).save(newsArgumentCaptor.capture());
        News createdNews = newsArgumentCaptor.getValue();
        assertThat(createdNews).isEqualTo(news);

    }

    @Test
    void itShouldCheckIfUserNull(){
        //given
        News news = new News();
        news.setTitle("Test title");
        news.setText("Hello world!");

        //when
        //then
        assertThatThrownBy(() -> underTest.create(news, USER_ID))
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessageContaining("User not found!");

        verify(newsRepository, never()).save(any());

    }

    @Test
    void itShouldDeleteNews() {
        //given
        News news = new News();
        news.setId(NEWS_ID);
        news.setTitle("Test title");
        news.setText("Hello world!");

        given(newsRepository.findById(NEWS_ID)).willReturn(java.util.Optional.of(news));

        //when
        underTest.delete(NEWS_ID);

        //then
        ArgumentCaptor<News> deletedNewsCaptor = ArgumentCaptor.forClass(News.class);
        verify(newsRepository).delete(deletedNewsCaptor.capture());
        News deletedNews = deletedNewsCaptor.getValue();

        assertNotNull(deletedNews);
        assertThat(deletedNews).isEqualTo(news);
    }

    @Test
    void itShouldCheckIfNewsNull(){
        //when
        underTest.delete(NEWS_ID);
        //then
        verify(newsRepository, never()).delete(any());
    }

    @Test
    void itShouldGetAllNews() {
        //when
        underTest.getAll();
        //then
        verify(newsRepository).findAll();
    }

    @Test
    void itShouldFindNewsByID() {
        //given
        News news = new News();
        news.setId(NEWS_ID);
        news.setTitle("Test title");
        news.setText("Hello world!");
        given(newsRepository.findById(NEWS_ID)).willReturn(java.util.Optional.of(news));

        //when
        News findedNews = underTest.findById(NEWS_ID);

        //then
        assertNotNull(findedNews);
        assertThat(findedNews).isEqualTo(news);
    }

}