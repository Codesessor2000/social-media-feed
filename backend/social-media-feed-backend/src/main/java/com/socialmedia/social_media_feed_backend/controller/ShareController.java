package com.socialmedia.social_media_feed_backend.controller;

import com.socialmedia.social_media_feed_backend.model.Share;
import com.socialmedia.social_media_feed_backend.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shares")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<Share> sharePost(@PathVariable Long userId, @PathVariable Long postId) {
        return ResponseEntity.ok(shareService.sharePost(userId, postId));
    }
}
