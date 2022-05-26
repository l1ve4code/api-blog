package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.LikeDAO;
import ru.live4code.blog.api.dto.LikeDTO;
import ru.live4code.blog.api.security.jwt.JwtUser;
import ru.live4code.blog.api.service.LikeService;
import ru.live4code.blog.data.like.Like;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDAO likeDAO;

    @Override
    public LikeDTO create(Authentication authentication, long news_id) {
        long user_id = ((JwtUser) authentication.getPrincipal()).getId();
        if (likeDAO.findByUserAndNews(user_id, news_id) != null) return null;
        Like created = likeDAO.create(user_id, news_id);
        if (created == null) return null;
        return LikeDTO.from(created);
    }

    @Override
    public LikeDTO delete(Authentication authentication, long news_id) {
        long user_id = ((JwtUser) authentication.getPrincipal()).getId();
        if (likeDAO.findByUserAndNews(user_id, news_id) == null) return null;
        Like deleted = likeDAO.delete(user_id, news_id);
        if (deleted == null) return null;
        return LikeDTO.from(deleted);
    }

    @Override
    public List<LikeDTO> getAll() {
        return likeDAO.getAll().stream().map(LikeDTO::from).collect(Collectors.toList());
    }

    @Override
    public LikeDTO findById(long id) {
        Like find = likeDAO.findById(id);
        if (find == null) return null;
        return LikeDTO.from(find);
    }
}
