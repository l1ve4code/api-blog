package ru.live4code.blog.api.service;

import ru.live4code.blog.data.news.News;

import java.util.List;

public interface NewsService {
    News create(News news, long user_id);
    News delete(long id);
    List<News> getAll();
    News findById(long id);
}
