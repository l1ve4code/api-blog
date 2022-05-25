package ru.live4code.blog.api.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.live4code.blog.api.dao.NewsDAO;
import ru.live4code.blog.api.dao.repository.NewsRepository;
import ru.live4code.blog.api.dao.repository.UserRepository;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.user.User;

import java.util.List;

@Component
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public News create(News news, long user_id) {
        User user = userRepository.findById(user_id).orElse(null);
        if (user == null) return null;
        news.setUser(user);
        newsRepository.save(news);
        return news;
    }

    @Override
    public News delete(long id) {
        News news = newsRepository.findById(id).orElse(null);
        if (news == null) return null;
        newsRepository.delete(news);
        return news;
    }

    @Override
    public List<News> getAll() {
        List<News> news = (List<News>) newsRepository.findAll();
        return news;
    }

    @Override
    public News findById(long id) {
        News news = newsRepository.findById(id).orElse(null);
        if (news == null) return null;
        return news;
    }
}
