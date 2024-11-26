package com.mirceanealcos.socialmedia.service.impl;

import com.mirceanealcos.socialmedia.dto.post.PostAddDto;
import com.mirceanealcos.socialmedia.dto.post.PostDto;
import com.mirceanealcos.socialmedia.dto.post.PostUpdateDto;
import com.mirceanealcos.socialmedia.dto.user.UserPostDto;
import com.mirceanealcos.socialmedia.entity.Post;
import com.mirceanealcos.socialmedia.entity.User;
import com.mirceanealcos.socialmedia.entity.enums.Status;
import com.mirceanealcos.socialmedia.repository.PostRepository;
import com.mirceanealcos.socialmedia.repository.UserRepository;
import com.mirceanealcos.socialmedia.service.PostService;
import com.mirceanealcos.socialmedia.util.mapper.PostDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, Validator validator) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public PostDto findById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        return PostDtoMapper.toPostDto(post);
    }

    @Override
    public PostDto addPost(PostAddDto postAddDto) {
        Set<ConstraintViolation<PostAddDto>> violations = validator.validate(postAddDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User user = userRepository.findById(postAddDto.getUserId()).orElse(null);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + postAddDto.getUserId() + " not found");
        }
        Post post = PostDtoMapper.toPostForAdd(postAddDto);
        post.setUser(user);
        post = postRepository.save(post);
        return PostDtoMapper.toPostDto(post);
    }

    @Override
    public void deleteById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new EntityNotFoundException("Post with id " + id + " not found");
        }
        postRepository.delete(post);
    }

    @Override
    public PostDto updatePost(Long id, PostUpdateDto postDto) {
        Set<ConstraintViolation<PostUpdateDto>> violations = validator.validate(postDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new EntityNotFoundException("Post with id " + id + " not found");
        }
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setStatus(Status.valueOf(postDto.getStatus()));
        post = postRepository.save(post);
        return PostDtoMapper.toPostDto(post);
    }

    @Override
    public List<PostDto> findPublishedPostsByUserId(Long userId) {
        List<Post> posts = postRepository.findPublishedPostsByUserId(userId);
        return posts.stream().map(PostDtoMapper::toPostDto).toList();
    }

    @Override
    public List<PostDto> findPendingPostsByUserId(Long userId) {
        List<Post> posts = postRepository.findPendingPostsByUserId(userId);
        return posts.stream().map(PostDtoMapper::toPostDto).toList();
    }

    @Override
    public List<PostDto> findAllPublishedPosts() {
        List<Post> posts = postRepository.findAllPublishedPosts();
        return posts.stream().map(PostDtoMapper::toPostDto).toList();
    }

    @Override
    public List<PostDto> findAllPendingPosts() {
        List<Post> posts = postRepository.findAllPendingPosts();
        return posts.stream().map(PostDtoMapper::toPostDto).toList();
    }

    @Override
    public List<PostDto> findByKeyword(String keyword) {
        List<Post> posts = postRepository.findByKeyword(keyword);
        return posts.stream().map(PostDtoMapper::toPostDto).toList();
    }

    @Override
    public void approvePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new EntityNotFoundException("Post with id " + id + " not found");
        }
        post.setStatus(Status.PUBLISHED);
        postRepository.save(post);
    }
}
