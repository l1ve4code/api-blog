package ru.live4code.blog.api.dto;

import lombok.Data;
import ru.live4code.blog.data.like.Like;

@Data
public class LikeDTO {

    private long user_id;
    private long news_id;

    public static LikeDTO from(Like like){
        LikeDTO dto = new LikeDTO();
        dto.setNews_id(like.getNews().getId());
        dto.setUser_id(like.getUser().getId());
        return dto;
    }

}
