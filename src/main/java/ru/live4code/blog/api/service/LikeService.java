package ru.live4code.blog.api.service;

import ru.live4code.blog.data.like.Like;

import java.util.List;

public interface LikeService {
    Like create(Like like, long user_id, long news_id);
    Like delete(long id);
    List<Like> getAll();
    Like findById(long id);
}
