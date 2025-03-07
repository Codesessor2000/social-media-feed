package com.socialmedia.social_media_feed_backend.repository;

import com.socialmedia.social_media_feed_backend.model.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShareRepository extends JpaRepository<Share, Long> {
    List<Share> findByPostId(Long postId);
}
