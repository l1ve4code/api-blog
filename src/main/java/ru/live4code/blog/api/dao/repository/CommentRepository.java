package ru.live4code.blog.api.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.live4code.blog.data.comment.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
