package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.NewsDAO;
import ru.live4code.blog.api.service.NewsService;
import ru.live4code.blog.data.news.News;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public News create(News news, long user_id) {
        return newsDAO.create(news, user_id);
    }

    @Override
    public News delete(long id) {
        return newsDAO.delete(id);
    }

    @Override
    public List<News> getAll() {
        return newsDAO.getAll();
    }

    @Override
    public News findById(long id) {
        return newsDAO.findById(id);
    }
}
