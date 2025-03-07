package com.socialmedia.social_media_feed_backend.service;

import com.socialmedia.social_media_feed_backend.model.Like;
import com.socialmedia.social_media_feed_backend.model.Post;
import com.socialmedia.social_media_feed_backend.model.User;
import com.socialmedia.social_media_feed_backend.repository.LikeRepository;
import com.socialmedia.social_media_feed_backend.repository.PostRepository;
import com.socialmedia.social_media_feed_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Like likePost(Long userId, Long postId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Post> post = postRepository.findById(postId);

        if (user.isPresent() && post.isPresent()) {
            Like like = new Like();
            like.setUser(user.get());
            like.setPost(post.get());
            return likeRepository.save(like);
        }
        throw new RuntimeException("User or Post not found");
    }

    public void unlikePost(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
