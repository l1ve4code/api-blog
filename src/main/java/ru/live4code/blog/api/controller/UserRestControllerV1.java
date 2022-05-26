package ru.live4code.blog.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.live4code.blog.api.dto.CommentDTO;
import ru.live4code.blog.api.dto.LikeDTO;
import ru.live4code.blog.api.service.CommentService;
import ru.live4code.blog.api.service.LikeService;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestControllerV1 {

    @Autowired
    private LikeService likeService;

    @Autowired
    private CommentService commentService;

    // LIKES
    @PostMapping("/like/{id}")
    public ResponseEntity<LikeDTO> setLiked(Authentication authentication, @PathVariable("id") long id) {
        LikeDTO like = likeService.create(authentication, id);
        if (like == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/like/{id}")
    public ResponseEntity<LikeDTO> setDisliked(Authentication authentication, @PathVariable("id") long id) {
        LikeDTO like = likeService.delete(authentication, id);
        if (like == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(like);
    }

    // COMMENTS
    @PostMapping("/comment/{id}")
    public ResponseEntity<CommentDTO> addComment(@PathVariable("id") long id, @RequestBody CommentDTO commentDTO) {
        CommentDTO comment = commentService.create(CommentDTO.to(commentDTO), id);
        if (comment == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(comment);
    }
}
