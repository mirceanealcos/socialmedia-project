package com.mirceanealcos.socialmedia.service.impl;

import com.mirceanealcos.socialmedia.dto.user.MailDto;
import com.mirceanealcos.socialmedia.dto.user.UserLoginDto;
import com.mirceanealcos.socialmedia.dto.user.UserPostDto;
import com.mirceanealcos.socialmedia.entity.User;
import com.mirceanealcos.socialmedia.exception.LoginException;
import com.mirceanealcos.socialmedia.repository.UserRepository;
import com.mirceanealcos.socialmedia.service.UserService;
import com.mirceanealcos.socialmedia.dto.user.UserDto;
import com.mirceanealcos.socialmedia.util.mapper.UserDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;
    private final JavaMailSender mailSender;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Validator validator, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.mailSender = mailSender;
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

    @Override
    public UserDto login(UserLoginDto loginDto) throws LoginException {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElse(null);
        Set<ConstraintViolation<UserLoginDto>> violations = validator.validate(loginDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        if (user == null) {
            throw new EntityNotFoundException("User with email " + loginDto.getEmail() + " not found");
        }
        if (user.getPassword().equals(loginDto.getPassword())) {
            return UserDtoMapper.toUserDto(user);
        }
        throw new LoginException();
    }

    @Override
    public void sendMail(MailDto mailDto) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getTo());
        message.setSubject(mailDto.getSubject());
        message.setText(mailDto.getContent());
        message.setFrom("socialbuggy@outlook.com");
        mailSender.send(message);
    }
}
