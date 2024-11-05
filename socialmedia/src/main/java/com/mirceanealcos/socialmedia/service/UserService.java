package com.mirceanealcos.socialmedia.service;

import com.mirceanealcos.socialmedia.dto.user.UserDto;
import com.mirceanealcos.socialmedia.dto.user.UserPostDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto getById(Long id);
    UserDto addUser(UserPostDto userDto);
    UserDto updateUser(Long id, UserPostDto userDto);
    void deleteUser(Long id);

}
