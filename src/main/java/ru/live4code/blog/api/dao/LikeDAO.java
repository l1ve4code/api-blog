package ru.live4code.blog.api.dao;

import ru.live4code.blog.data.like.Like;

import java.util.List;

public interface LikeDAO {
    Like create(Like like, long user_id, long news_id);
    Like delete(long id);
    List<Like> getAll();
    Like findById(long id);
}
