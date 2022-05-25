package ru.live4code.blog.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.live4code.blog.api.dao.CommentDAO;
import ru.live4code.blog.api.service.CommentService;
import ru.live4code.blog.data.comment.Comment;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment create(Comment comment, long news_id) {
        return commentDAO.create(comment, news_id);
    }

    @Override
    public Comment delete(long id) {
        return commentDAO.delete(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentDAO.getAll();
    }

    @Override
    public Comment findById(long id) {
        return commentDAO.findById(id);
    }
}
