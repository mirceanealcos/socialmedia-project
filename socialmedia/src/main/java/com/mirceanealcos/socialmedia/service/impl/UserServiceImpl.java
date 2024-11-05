package com.mirceanealcos.socialmedia.service.impl;

import com.mirceanealcos.socialmedia.dto.user.UserPostDto;
import com.mirceanealcos.socialmedia.entity.User;
import com.mirceanealcos.socialmedia.repository.UserRepository;
import com.mirceanealcos.socialmedia.service.UserService;
import com.mirceanealcos.socialmedia.dto.user.UserDto;
import com.mirceanealcos.socialmedia.util.mapper.UserDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(UserDtoMapper.toUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return UserDtoMapper.toUserDto(user);
    }

    @Override
    public UserDto addUser(UserPostDto userDto) {
        Set<ConstraintViolation<UserPostDto>> violations = validator.validate(userDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User user = UserDtoMapper.toUserForAdd(userDto);
        user = userRepository.save(user);
        return UserDtoMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserPostDto userDto) {
        Set<ConstraintViolation<UserPostDto>> violations = validator.validate(userDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user = userRepository.save(user);
        return UserDtoMapper.toUserDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new EntityNotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }
}
