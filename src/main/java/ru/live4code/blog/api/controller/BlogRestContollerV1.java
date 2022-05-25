package ru.live4code.blog.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.live4code.blog.api.dto.NewsDTO;
import ru.live4code.blog.api.service.NewsService;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogRestContollerV1 {

    @Autowired
    private NewsService newsService;

    // NEWS
    @GetMapping("/news")
    public ResponseEntity getAllNews(){
        return ResponseEntity.ok(newsService.getAll());
    }

    @GetMapping("/news/{id}")
    public ResponseEntity getNewsById(@PathVariable("id") long id){
        NewsDTO news = newsService.findById(id);
        if (news == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(news);
    }


}
