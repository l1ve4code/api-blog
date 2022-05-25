package ru.live4code.blog.api.service;

import ru.live4code.blog.api.dto.LikeDTO;
import ru.live4code.blog.data.like.Like;

import java.util.List;

public interface LikeService {
    LikeDTO create(long user_id, long news_id);
    LikeDTO delete(long id);
    List<LikeDTO> getAll();
    LikeDTO findById(long id);
}
