package com.codecool.bookclub.forum.controller;

import com.codecool.bookclub.forum.dto.NewCommentDto;
import com.codecool.bookclub.forum.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/comments")
    public void createComment(@RequestBody NewCommentDto comment, @AuthenticationPrincipal Long userId){
        commentService.createComment(comment, userId);
    }

    @GetMapping("/comments/{id}/report-abuse")
    public ResponseEntity<String> reportAbuse(@PathVariable("id") long id){
        return commentService.reportAbuse(id);
    }


    @DeleteMapping("/comments/{comment_id}")
    public void deleteComment(@PathVariable("comment_id") long commentId){
        commentService.deleteComment(commentId);
    }



}
