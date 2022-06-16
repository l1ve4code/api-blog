package ru.live4code.blog.api.dao.implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.live4code.blog.api.dao.CommentDAO;
import ru.live4code.blog.api.dao.repository.CommentRepository;
import ru.live4code.blog.api.dao.repository.NewsRepository;
import ru.live4code.blog.data.comment.Comment;
import ru.live4code.blog.data.news.News;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CommentDAOImplTest {

    private static long NEWS_ID = 1L;
    private static long COMMENT_ID = 1L;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private NewsRepository newsRepository;

    @InjectMocks
    private CommentDAO underTest = new CommentDAOImpl();

    @Test
    void itShouldCreateComment(){
        //given
        News news = new News();
        news.setId(NEWS_ID);
        news.setTitle("Test title");
        news.setText("Hello world!");

        Comment comment = new Comment();
        comment.setText("Test");


        given(newsRepository.findById(NEWS_ID)).willReturn(java.util.Optional.of(news));

        //when
        underTest.create(comment, NEWS_ID);

        //then
        ArgumentCaptor<Comment> commentArgumentCaptor = ArgumentCaptor.forClass(Comment.class);
        verify(commentRepository).save(commentArgumentCaptor.capture());
        Comment createdComment = commentArgumentCaptor.getValue();

        assertNotNull(createdComment);
        assertThat(createdComment).isEqualTo(comment);
    }

    @Test
    void itShouldDeleteComment(){
        //given
        Comment comment = new Comment();
        comment.setId(COMMENT_ID);
        comment.setText("Test");

        given(commentRepository.findById(COMMENT_ID)).willReturn(java.util.Optional.of(comment));

        //when
        underTest.delete(COMMENT_ID);

        //then
        ArgumentCaptor<Comment> deletedCommentCaptor = ArgumentCaptor.forClass(Comment.class);
        verify(commentRepository).delete(deletedCommentCaptor.capture());
        Comment deletedComment = deletedCommentCaptor.getValue();

        assertThat(deletedComment).isEqualTo(comment);

    }

    @Test
    void itShouldCheckIfNewsNull(){
        //given
        Comment comment = new Comment();
        comment.setText("Test");

        //when
        underTest.create(comment, NEWS_ID);

        //then
        verify(commentRepository, never()).save(any());
    }

    @Test
    void itShouldGetAllComments(){
        //when
        underTest.getAll();

        //then
        verify(commentRepository).findAll();
    }

    @Test
    void itShouldGetCommentByID(){
        //given
        Comment comment = new Comment();
        comment.setId(COMMENT_ID);
        comment.setText("Test");

        given(commentRepository.findById(COMMENT_ID)).willReturn(java.util.Optional.of(comment));

        //when
        Comment findedComment = underTest.findById(COMMENT_ID);

        //then
        assertNotNull(findedComment);
        assertThat(findedComment).isEqualTo(comment);
    }

}