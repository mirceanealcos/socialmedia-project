package com.mirceanealcos.socialmedia.controller;

import com.mirceanealcos.socialmedia.dto.post.PostAddDto;
import com.mirceanealcos.socialmedia.dto.post.PostDto;
import com.mirceanealcos.socialmedia.dto.post.PostUpdateDto;
import com.mirceanealcos.socialmedia.response.ErrorResponse;
import com.mirceanealcos.socialmedia.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/posts")
@Slf4j
@CrossOrigin(origins = "*")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            PostDto postDto = postService.findById(id);
            return ResponseEntity.ok(postDto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addPost(@RequestBody PostAddDto postDto) {
        try {
            PostDto dto = postService.addPost(postDto);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts"),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        try {
            postService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable Long id, @RequestBody PostUpdateDto postDto) {
        try {
            PostDto dto = postService.updatePost(id, postDto);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findPublishedPostsByUserId(@PathVariable Long id) {
        try {
            List<PostDto> dtoList = postService.findPublishedPostsByUserId(id);
            return ResponseEntity.ok(dtoList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/user/" + id), INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pending/user/{id}")
    public ResponseEntity<Object> findPendingPostsByUserId(@PathVariable Long id) {
        try {
            List<PostDto> dtoList = postService.findPendingPostsByUserId(id);
            return ResponseEntity.ok(dtoList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/user/" + id), INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/published")
    public ResponseEntity<Object> findPublishedPosts() {
        try {
            List<PostDto> dtoList = postService.findAllPublishedPosts();
            return ResponseEntity.ok(dtoList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/published"), INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pending")
    public ResponseEntity<Object> findPendingPosts() {
        try {
            List<PostDto> dtoList = postService.findAllPendingPosts();
            return ResponseEntity.ok(dtoList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/published"), INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/params")
    public ResponseEntity<Object> findByKeyword(@RequestParam String keyword) {
        try {
            List<PostDto> dtoList = postService.findByKeyword(keyword);
            return ResponseEntity.ok(dtoList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/params?keyword=" + keyword), INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<Object> approvePost(@PathVariable Long id) {
        try {
            postService.approvePost(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/posts/approve/" + id), INTERNAL_SERVER_ERROR);
        }
    }

}
