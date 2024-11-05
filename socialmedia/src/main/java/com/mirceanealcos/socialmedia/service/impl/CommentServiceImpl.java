package com.mirceanealcos.socialmedia.service.impl;

import com.mirceanealcos.socialmedia.dto.comment.CommentDto;
import com.mirceanealcos.socialmedia.dto.comment.CommentPostDto;
import com.mirceanealcos.socialmedia.dto.comment.CommentUpdateDto;
import com.mirceanealcos.socialmedia.entity.Comment;
import com.mirceanealcos.socialmedia.entity.Post;
import com.mirceanealcos.socialmedia.entity.User;
import com.mirceanealcos.socialmedia.repository.CommentRepository;
import com.mirceanealcos.socialmedia.repository.PostRepository;
import com.mirceanealcos.socialmedia.repository.UserRepository;
import com.mirceanealcos.socialmedia.service.CommentService;
import com.mirceanealcos.socialmedia.util.mapper.CommentDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository, Validator validator) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public CommentDto findById(Long id) {
        return CommentDtoMapper.toCommentDto(commentRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(Long id, CommentUpdateDto commentDto) {
        Set<ConstraintViolation<CommentUpdateDto>> violations = validator.validate(commentDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment == null) {
            throw new EntityNotFoundException("Comment with id " + id + " not found");
        }
        comment.setContent(commentDto.getContent());
        comment = commentRepository.save(comment);
        return CommentDtoMapper.toCommentDto(comment);
    }

    @Override
    public CommentDto addComment(CommentPostDto commentDto) {
        Set<ConstraintViolation<CommentPostDto>> violations = validator.validate(commentDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User user = userRepository.findById(commentDto.getUserId()).orElse(null);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + commentDto.getUserId() + " not found");
        }
        Post post = postRepository.findById(commentDto.getPostId()).orElse(null);
        if (post == null) {
            throw new EntityNotFoundException("Post with id " + commentDto.getPostId() + " not found");
        }
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(commentDto.getContent());
        return CommentDtoMapper.toCommentDto(commentRepository.save(comment));
    }

    @Override
    public List<CommentDto> findAllForPost(Long postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);
        return comments.stream().map(CommentDtoMapper::toCommentDto).toList();
    }
}
