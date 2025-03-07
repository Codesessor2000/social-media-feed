package com.socialmedia.social_media_feed_backend.service;

import com.socialmedia.social_media_feed_backend.model.Post;
import com.socialmedia.social_media_feed_backend.model.User;
import com.socialmedia.social_media_feed_backend.repository.PostRepository;
import com.socialmedia.social_media_feed_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post createPost(Post post) {
        Optional<User> user = userRepository.findById(post.getUser().getId());
        if (user.isPresent()) {
            post.setUser(user.get()); // Set full user details
            return postRepository.save(post);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post updatePost(Long id, Post postDetails) {
        return postRepository.findById(id).map(post -> {
            post.setContent(postDetails.getContent());
            post.setImageUrl(postDetails.getImageUrl());
            return postRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
