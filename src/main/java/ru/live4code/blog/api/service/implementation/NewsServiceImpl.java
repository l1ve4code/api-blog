package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.LikeDAO;
import ru.live4code.blog.api.dao.NewsDAO;
import ru.live4code.blog.api.dto.NewsDTO;
import ru.live4code.blog.api.security.jwt.JwtUser;
import ru.live4code.blog.api.service.NewsService;
import ru.live4code.blog.data.news.News;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Autowired
    private LikeDAO likeDAO;

    @Override
    public NewsDTO create(News news, Authentication authentication) {
        long user_id = ((JwtUser) authentication.getPrincipal()).getId();
        News created = newsDAO.create(news, user_id);
        if (created == null) return null;
        return NewsDTO.from(created);
    }

    @Override
    public NewsDTO delete(long id) {
        News deleted = newsDAO.delete(id);
        if (deleted == null) return null;
        return NewsDTO.from(deleted);
    }

    @Override
    public List<NewsDTO> getAll(Authentication authentication) {
        return newsDAO.getAll().stream().map(NewsDTO::from).collect(Collectors.toList());
    }

    @Override
    public NewsDTO findById(Authentication authentication, long id) {
        News find = newsDAO.findById(id);
        if (find == null) return null;
        NewsDTO finded = NewsDTO.from(find);
        if(authentication != null && authentication.isAuthenticated()){
            long user_id = ((JwtUser) authentication.getPrincipal()).getId();
            finded.setIsLiked(false);
            if (likeDAO.findByUserAndNews(user_id, id) != null) {
                finded.setIsLiked(true);
            }
        }
        return finded;
    }
}
