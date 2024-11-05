package com.mirceanealcos.socialmedia.util.mapper;

import com.mirceanealcos.socialmedia.dto.user.UserDto;
import com.mirceanealcos.socialmedia.dto.user.UserPostDto;
import com.mirceanealcos.socialmedia.entity.User;

public class UserDtoMapper {

    public static UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toUserForAdd(UserPostDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }



}
