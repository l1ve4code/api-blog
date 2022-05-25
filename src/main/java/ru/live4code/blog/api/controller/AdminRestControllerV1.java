package ru.live4code.blog.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.live4code.blog.api.dto.CommentDTO;
import ru.live4code.blog.api.dto.NewsDTO;
import ru.live4code.blog.api.dto.RoleDTO;
import ru.live4code.blog.api.security.jwt.JwtUser;
import ru.live4code.blog.api.service.CommentService;
import ru.live4code.blog.api.service.NewsService;
import ru.live4code.blog.api.service.RoleService;
import ru.live4code.blog.data.news.News;
import ru.live4code.blog.data.role.Role;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestControllerV1 {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RoleService roleService;

    @DeleteMapping("/comment/{id}")
    public ResponseEntity deleteComment(@PathVariable("id") long id) {
        CommentDTO comment = commentService.delete(id);
        if (comment == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/news")
    public ResponseEntity addNews(Authentication authentication, @RequestBody NewsDTO newsDTO) {
        long user_id = ((JwtUser) authentication.getPrincipal()).getId();
        News news = NewsDTO.to(newsDTO);
        NewsDTO isCreated = newsService.create(news, user_id);
        if (isCreated == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(isCreated);
    }

    @DeleteMapping("/news/{id}")
    public ResponseEntity deleteNews(@PathVariable("id") long id) {
        NewsDTO news = newsService.findById(id);
        if (news == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(news);
    }

    @PostMapping("/role")
    public ResponseEntity role(@RequestBody RoleDTO roleDTO) {
        Role role = roleService.create(RoleDTO.to(roleDTO));
        return ResponseEntity.ok(role);
    }

}
