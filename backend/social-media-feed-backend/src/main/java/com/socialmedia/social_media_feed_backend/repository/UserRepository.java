package com.socialmedia.social_media_feed_backend.repository;

import com.socialmedia.social_media_feed_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
