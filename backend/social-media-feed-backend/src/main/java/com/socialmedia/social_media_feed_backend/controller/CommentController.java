package com.socialmedia.social_media_feed_backend.controller;

import com.socialmedia.social_media_feed_backend.model.Comment;
import com.socialmedia.social_media_feed_backend.service.CommentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<Comment> addComment(@PathVariable Long userId, @PathVariable Long postId, @RequestBody String content) {
        return ResponseEntity.ok(commentService.addComment(userId, postId, content));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPost(postId));
    }
}
