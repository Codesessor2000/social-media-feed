package com.socialmedia.social_media_feed_backend.service;

import com.socialmedia.social_media_feed_backend.model.Comment;
import com.socialmedia.social_media_feed_backend.model.Post;
import com.socialmedia.social_media_feed_backend.model.User;
import com.socialmedia.social_media_feed_backend.repository.CommentRepository;
import com.socialmedia.social_media_feed_backend.repository.PostRepository;
import com.socialmedia.social_media_feed_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment addComment(Long userId, Long postId, String content) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Post> post = postRepository.findById(postId);

        if (user.isPresent() && post.isPresent()) {
            Comment comment = new Comment();
            comment.setUser(user.get());
            comment.setPost(post.get());
            comment.setContent(content);
            return commentRepository.save(comment);
        }
        throw new RuntimeException("User or Post not found");
    }

    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
