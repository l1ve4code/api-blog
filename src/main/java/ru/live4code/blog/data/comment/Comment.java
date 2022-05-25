package ru.live4code.blog.data.comment;

import lombok.Data;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.util.UniqueFields;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
public class Comment extends UniqueFields {

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

}
