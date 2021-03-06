package ru.live4code.blog.api.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.live4code.blog.data.news.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
}
