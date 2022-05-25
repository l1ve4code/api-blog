package ru.live4code.blog.data.like;

import lombok.Data;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.user.User;
import ru.live4code.blog.data.util.UniqueFields;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "likes")
public class Like extends UniqueFields {

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
