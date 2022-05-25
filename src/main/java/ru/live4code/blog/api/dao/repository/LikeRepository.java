package ru.live4code.blog.api.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.live4code.blog.data.like.Like;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.user.User;

import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
    Like findByUserAndNews(User user, News news);
}
