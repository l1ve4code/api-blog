package ru.live4code.blog.api.dto;

import lombok.Data;
import ru.live4code.blog.data.news.News;

@Data
public class NewsDTO {

    private String title;
    private String text;

    public static NewsDTO from(News news){
        NewsDTO dto = new NewsDTO();
        dto.setTitle(news.getTitle());
        dto.setText(news.getText());
        return dto;
    }

    public static News to(NewsDTO dto){
        News news = new News();
        news.setTitle(dto.getTitle());
        news.setText(dto.getText());
        return news;
    }

}
