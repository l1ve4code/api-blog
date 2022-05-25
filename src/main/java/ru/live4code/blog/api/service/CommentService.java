package ru.live4code.blog.api.service;

import ru.live4code.blog.api.dto.CommentDTO;
import ru.live4code.blog.data.comment.Comment;

import java.util.List;

public interface CommentService {
    CommentDTO create(Comment comment, long news_id);
    CommentDTO delete(long id);
    List<CommentDTO> getAll();
    CommentDTO findById(long id);
}
