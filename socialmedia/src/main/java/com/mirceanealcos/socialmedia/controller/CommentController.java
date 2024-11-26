package com.mirceanealcos.socialmedia.controller;

import com.mirceanealcos.socialmedia.dto.comment.CommentDto;
import com.mirceanealcos.socialmedia.dto.comment.CommentPostDto;
import com.mirceanealcos.socialmedia.dto.comment.CommentUpdateDto;
import com.mirceanealcos.socialmedia.response.ErrorResponse;
import com.mirceanealcos.socialmedia.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/comments")
@Slf4j
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            CommentDto commentDto = commentService.findById(id);
            return ResponseEntity.ok(commentDto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/comments/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {
        try {
            List<CommentDto> resultList = commentService.findAll();
            return ResponseEntity.ok(resultList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/comments/"),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        try {
            commentService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/comments/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateComment(@PathVariable Long id, @RequestBody CommentUpdateDto putDto) {
        try {
            CommentDto dto = commentService.updateComment(id, putDto);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/comments/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addComment(@RequestBody CommentPostDto commentDto) {
        try {
            CommentDto dto = commentService.addComment(commentDto);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/comments"),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Object> getByPostId(@PathVariable Long id) {
        try {
            List<CommentDto> resultList = commentService.findAllForPost(id);
            return ResponseEntity.ok(resultList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/comments/post/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/params")
    public ResponseEntity<Object> getByParams(@RequestParam String keyword) {
        try {
            List<CommentDto> resultList = commentService.findByKeyword(keyword);
            return ResponseEntity.ok(resultList);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/comments/params?keyword=" + keyword),
                    INTERNAL_SERVER_ERROR);
        }
    }

}
