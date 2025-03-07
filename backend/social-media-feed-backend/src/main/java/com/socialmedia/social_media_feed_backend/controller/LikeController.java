package com.socialmedia.social_media_feed_backend.controller;

import com.socialmedia.social_media_feed_backend.model.Like;
import com.socialmedia.social_media_feed_backend.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<Like> likePost(@PathVariable Long userId, @PathVariable Long postId) {
        return ResponseEntity.ok(likeService.likePost(userId, postId));
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<String> unlikePost(@PathVariable Long likeId) {
        likeService.unlikePost(likeId);
        return ResponseEntity.ok("Like removed");
    }
}
