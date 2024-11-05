package com.mirceanealcos.socialmedia.controller;

import com.mirceanealcos.socialmedia.dto.user.UserPostDto;
import com.mirceanealcos.socialmedia.response.ErrorResponse;
import com.mirceanealcos.socialmedia.service.UserService;
import com.mirceanealcos.socialmedia.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        try {
            List<UserDto> userDtos = userService.getAllUsers();
            return ResponseEntity.ok(userDtos);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/users"),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        try {
            UserDto userDto = userService.getById(id);
            return ResponseEntity.ok(userDto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/users/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody UserPostDto userDto) {
        try {
            UserDto dto = userService.addUser(userDto);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/users"),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Long id, @RequestBody UserPostDto userDto) {
        try {
            UserDto dto = userService.updateUser(id, userDto);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/users/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new ErrorResponse(e.getClass().getCanonicalName(), e.getMessage(), "/users/" + id),
                    INTERNAL_SERVER_ERROR);
        }
    }

}
