package ru.live4code.blog.api.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.live4code.blog.data.like.Like;

import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
}
