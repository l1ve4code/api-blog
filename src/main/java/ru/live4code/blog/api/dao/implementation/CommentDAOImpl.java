package ru.live4code.blog.api.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.live4code.blog.api.dao.CommentDAO;
import ru.live4code.blog.api.dao.repository.CommentRepository;
import ru.live4code.blog.api.dao.repository.NewsRepository;
import ru.live4code.blog.data.comment.Comment;
import ru.live4code.blog.data.news.News;

import java.util.Date;
import java.util.List;

@Component
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Comment create(Comment comment, long news_id) {
        News news = newsRepository.findById(news_id).orElse(null);
        if (news == null) return null;
        comment.setCreated_at(new Date());
        comment.setUpdated_at(new Date());
        comment.setNews(news);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment delete(long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment == null) return null;
        commentRepository.delete(comment);
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        List<Comment> comments = (List<Comment>) commentRepository.findAll();
        return comments;
    }

    @Override
    public Comment findById(long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment == null) return null;
        return comment;
    }
}
