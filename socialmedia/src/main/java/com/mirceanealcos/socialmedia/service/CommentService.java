package com.mirceanealcos.socialmedia.service;

import com.mirceanealcos.socialmedia.dto.comment.CommentDto;
import com.mirceanealcos.socialmedia.dto.comment.CommentPostDto;
import com.mirceanealcos.socialmedia.dto.comment.CommentUpdateDto;

import java.util.List;

public interface CommentService {
    CommentDto findById(Long id);
    void deleteById(Long id);
    CommentDto updateComment(Long id, CommentUpdateDto commentDto);
    CommentDto addComment(CommentPostDto commentDto);
    List<CommentDto> findAllForPost(Long postId);
    List<CommentDto> findAll();
    List<CommentDto> findByKeyword(String keyword);
}
