package ru.live4code.blog.api.service;

import ru.live4code.blog.api.dto.NewsDTO;
import ru.live4code.blog.data.news.News;

import java.util.List;

public interface NewsService {
    NewsDTO create(News news, long user_id);
    NewsDTO delete(long id);
    List<NewsDTO> getAll();
    NewsDTO findById(long id);
}
