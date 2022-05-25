package ru.live4code.blog.api.service;

import org.springframework.security.core.Authentication;
import ru.live4code.blog.api.dto.LikeDTO;
import ru.live4code.blog.data.like.Like;

import java.util.List;

public interface LikeService {
    LikeDTO create(Authentication authentication, long news_id);
    LikeDTO delete(Authentication authentication, long news_id);
    List<LikeDTO> getAll();
    LikeDTO findById(long id);
}
