package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.LikeDAO;
import ru.live4code.blog.api.service.LikeService;
import ru.live4code.blog.data.like.Like;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDAO likeDAO;

    @Override
    public Like create(Like like, long user_id, long news_id) {
        return likeDAO.create(like, user_id, news_id);
    }

    @Override
    public Like delete(long id) {
        return likeDAO.delete(id);
    }

    @Override
    public List<Like> getAll() {
        return likeDAO.getAll();
    }

    @Override
    public Like findById(long id) {
        return likeDAO.findById(id);
    }
}
