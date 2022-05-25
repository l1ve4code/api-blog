package ru.live4code.blog.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.live4code.blog.api.dto.CommentDTO;
import ru.live4code.blog.api.dto.NewsDTO;
import ru.live4code.blog.api.dto.RoleDTO;
import ru.live4code.blog.api.service.CommentService;
import ru.live4code.blog.api.service.NewsService;
import ru.live4code.blog.api.service.RoleService;
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
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable("id") long id) {
        CommentDTO comment = commentService.delete(id);
        if (comment == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/news")
    public ResponseEntity<NewsDTO> addNews(Authentication authentication, @RequestBody NewsDTO newsDTO) {
        NewsDTO created = newsService.create(NewsDTO.to(newsDTO), authentication);
        if (created == null) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/news/{id}")
    public ResponseEntity<NewsDTO> deleteNews(@PathVariable("id") long id) {
        NewsDTO deleted = newsService.delete(id);
        if (deleted == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(deleted);
    }

    @PostMapping("/role")
    public ResponseEntity<Role> role(@RequestBody RoleDTO roleDTO) {
        Role role = roleService.create(RoleDTO.to(roleDTO));
        return ResponseEntity.ok(role);
    }

}
