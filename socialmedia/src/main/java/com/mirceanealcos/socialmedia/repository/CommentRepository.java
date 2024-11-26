package com.mirceanealcos.socialmedia.repository;

import com.mirceanealcos.socialmedia.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c WHERE c.post.id=?1")
    List<Comment> findAllByPostId(Long postId);

    @Query(value = "SELECT c FROM Comment c WHERE c.content LIKE CONCAT('%',?1,'%')")
    List<Comment> findByKeyword(String keyword);

}
