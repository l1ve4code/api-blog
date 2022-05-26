package ru.live4code.blog.api.dao;

import ru.live4code.blog.data.like.Like;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.user.User;

import java.util.List;

public interface LikeDAO {
    Like create(long user_id, long news_id);
    Like delete(long user_id, long news_id);
    Like findByUserAndNews(long user_id, long news_id);
    List<Like> getAll();
    Like findById(long id);
}
