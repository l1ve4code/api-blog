package ru.live4code.blog.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.live4code.blog.data.news.News;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsDTO {

    private long id;
    private String title;
    private String text;
    private String owner_name;
    private Boolean isLiked;
    private List<CommentDTO> comments;
    private int like_amount;
    private int comment_amount;

    public static NewsDTO from(News news){
        NewsDTO dto = new NewsDTO();
        dto.setId(news.getId());
        dto.setTitle(news.getTitle());
        dto.setText(news.getText());
        dto.setOwner_name(news.getUser().getSurname() + " " + news.getUser().getName());
        if (news.getComments() != null) dto.setComments(news.getComments().stream().map(CommentDTO::from).collect(Collectors.toList()));
        if (news.getLikes() != null) dto.setLike_amount(news.getLikes().size());
        if (news.getComments() != null) dto.setComment_amount(news.getComments().size());
        return dto;
    }

    public static News to(NewsDTO dto){
        News news = new News();
        news.setTitle(dto.getTitle());
        news.setText(dto.getText());
        return news;
    }

}
