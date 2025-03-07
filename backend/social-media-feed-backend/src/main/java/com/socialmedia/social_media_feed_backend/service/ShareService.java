package com.socialmedia.social_media_feed_backend.service;

import com.socialmedia.social_media_feed_backend.model.Post;
import com.socialmedia.social_media_feed_backend.model.Share;
import com.socialmedia.social_media_feed_backend.model.User;
import com.socialmedia.social_media_feed_backend.repository.PostRepository;
import com.socialmedia.social_media_feed_backend.repository.ShareRepository;
import com.socialmedia.social_media_feed_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShareService {
    @Autowired
    private ShareRepository shareRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Share sharePost(Long userId, Long postId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Post> post = postRepository.findById(postId);

        if (user.isPresent() && post.isPresent()) {
            Share share = new Share();
            share.setUser(user.get());
            share.setPost(post.get());
            return shareRepository.save(share);
        }
        throw new RuntimeException("User or Post not found");
    }
}
