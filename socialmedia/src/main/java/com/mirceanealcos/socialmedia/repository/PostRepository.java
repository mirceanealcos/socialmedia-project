package com.mirceanealcos.socialmedia.repository;

import com.mirceanealcos.socialmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p from Post p WHERE p.user.id = ?1 AND p.status='PUBLISHED'")
    List<Post> findPublishedPostsByUserId(Long userId);
    @Query(value = "SELECT p from Post p WHERE p.user.id = ?1 AND p.status='PENDING'")
    List<Post> findPendingPostsByUserId(Long userId);
    @Query(value = "SELECT p from Post p WHERE p.status = 'PUBLISHED'")
    List<Post> findAllPublishedPosts();

}
