package ru.live4code.blog.api.dao;

import ru.live4code.blog.data.news.News;

import java.util.List;

public interface NewsDAO {
    News create(News news, long user_id);
    News delete(long id);
    List<News> getAll();
    News findById(long id);
}
