package ru.live4code.blog.data.news;

import lombok.Data;
import ru.live4code.blog.data.comment.Comment;
import ru.live4code.blog.data.like.Like;
import ru.live4code.blog.data.util.UniqueFields;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "news")
public class News extends UniqueFields {

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "news_id")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "news_id")
    private List<Like> likes;

}
