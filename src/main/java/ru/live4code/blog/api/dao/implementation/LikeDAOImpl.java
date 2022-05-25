package ru.live4code.blog.api.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import ru.live4code.blog.api.dao.LikeDAO;
import ru.live4code.blog.api.dao.repository.LikeRepository;
import ru.live4code.blog.api.dao.repository.NewsRepository;
import ru.live4code.blog.api.dao.repository.UserRepository;
import ru.live4code.blog.data.like.Like;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.user.User;

import java.util.List;

public class LikeDAOImpl implements LikeDAO {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Like create(Like like, long user_id, long news_id) {
        User user = userRepository.findById(user_id).orElse(null);
        News news = newsRepository.findById(news_id).orElse(null);
        if (user == null || news == null) return null;
        like.setNews(news);
        like.setUser(user);
        likeRepository.save(like);
        return like;
    }

    @Override
    public Like delete(long id) {
        Like like = likeRepository.findById(id).orElse(null);
        if (like == null) return null;
        likeRepository.delete(like);
        return like;
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
