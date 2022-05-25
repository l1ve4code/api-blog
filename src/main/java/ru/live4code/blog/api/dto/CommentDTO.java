package ru.live4code.blog.api.dto;

import lombok.Data;
import ru.live4code.blog.data.comment.Comment;

@Data
public class CommentDTO {

    private long id;
    private String text;
    private long news_id;

    public static CommentDTO from(Comment comment){
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setNews_id(comment.getNews().getId());
        return dto;
    }

    public static Comment to(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setText(commentDTO.getText());
        return comment;
    }

}
