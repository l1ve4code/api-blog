package ru.live4code.blog.api.dao;

import ru.live4code.blog.data.comment.Comment;

import java.util.List;

public interface CommentDAO {
    Comment create(Comment comment, long news_id);
    Comment delete(long id);
    List<Comment> getAll();
    Comment findById(long id);
}
