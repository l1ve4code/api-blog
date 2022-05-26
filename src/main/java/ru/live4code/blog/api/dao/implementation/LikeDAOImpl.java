package ru.live4code.blog.api.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.live4code.blog.api.dao.LikeDAO;
import ru.live4code.blog.api.dao.repository.LikeRepository;
import ru.live4code.blog.api.dao.repository.NewsRepository;
import ru.live4code.blog.api.dao.repository.UserRepository;
import ru.live4code.blog.data.like.Like;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.user.User;

import java.util.Date;
import java.util.List;

@Component
public class LikeDAOImpl implements LikeDAO {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Like create(long user_id, long news_id) {
        Like like = new Like();
        User user = userRepository.findById(user_id).orElse(null);
        News news = newsRepository.findById(news_id).orElse(null);
        if (user == null || news == null) return null;
        like.setCreated_at(new Date());
        like.setUpdated_at(new Date());
        like.setNews(news);
        like.setUser(user);
        likeRepository.save(like);
        return like;
    }

    @Override
    public Like delete(long user_id, long news_id) {
        News news = newsRepository.findById(news_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        if (news == null || user == null) return null;
        Like like = likeRepository.findByUserAndNews(user, news);
        if (like == null) return null;
        likeRepository.delete(like);
        return like;
    }

    @Override
    public Like findByUserAndNews(long user_id, long news_id) {
        News news = newsRepository.findById(news_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        if (news == null || user == null) return null;
        return likeRepository.findByUserAndNews(user, news);
    }

    @Override
    public List<Like> getAll() {
        List<Like> likes = (List<Like>) likeRepository.findAll();
        return likes;
    }

    @Override
    public Like findById(long id) {
        Like like = likeRepository.findById(id).orElse(null);
        if (like == null) return null;
        return like;
    }
}
