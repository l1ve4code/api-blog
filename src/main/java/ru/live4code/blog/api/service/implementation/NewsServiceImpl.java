package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.NewsDAO;
import ru.live4code.blog.api.dto.NewsDTO;
import ru.live4code.blog.api.service.NewsService;
import ru.live4code.blog.data.news.News;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public NewsDTO create(News news, long user_id) {
        return NewsDTO.from(newsDAO.create(news, user_id));
    }

    @Override
    public NewsDTO delete(long id) {
        return NewsDTO.from(newsDAO.delete(id));
    }

    @Override
    public List<NewsDTO> getAll() {
        return newsDAO.getAll().stream().map(NewsDTO::from).collect(Collectors.toList());
    }

    @Override
    public NewsDTO findById(long id) {
        return NewsDTO.from(newsDAO.findById(id));
    }
}
