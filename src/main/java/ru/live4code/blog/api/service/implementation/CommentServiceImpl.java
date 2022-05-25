package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.CommentDAO;
import ru.live4code.blog.api.dto.CommentDTO;
import ru.live4code.blog.api.service.CommentService;
import ru.live4code.blog.data.comment.Comment;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public CommentDTO create(Comment comment, long news_id) {
        Comment created = commentDAO.create(comment, news_id);
        if (created == null) return null;
        return CommentDTO.from(created);
    }

    @Override
    public CommentDTO delete(long id) {
        Comment deleted = commentDAO.delete(id);
        if (deleted == null) return null;
        return CommentDTO.from(deleted);
    }

    @Override
    public List<CommentDTO> getAll() {
        return commentDAO.getAll().stream().map(CommentDTO::from).collect(Collectors.toList());
    }

    @Override
    public CommentDTO findById(long id) {
        Comment find = commentDAO.findById(id);
        if (find == null) return null;
        return CommentDTO.from(find);
    }
}
