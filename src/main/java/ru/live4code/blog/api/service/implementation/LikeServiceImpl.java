package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.LikeDAO;
import ru.live4code.blog.api.dto.LikeDTO;
import ru.live4code.blog.api.service.LikeService;
import ru.live4code.blog.data.like.Like;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDAO likeDAO;

    @Override
    public LikeDTO create(long user_id, long news_id) {
        return LikeDTO.from(likeDAO.create(user_id, news_id));
    }

    @Override
    public LikeDTO delete(long id) {
        return LikeDTO.from(likeDAO.delete(id));
    }

    @Override
    public List<LikeDTO> getAll() {
        return likeDAO.getAll().stream().map(LikeDTO::from).collect(Collectors.toList());
    }

    @Override
    public LikeDTO findById(long id) {
        return LikeDTO.from(likeDAO.findById(id));
    }
}
