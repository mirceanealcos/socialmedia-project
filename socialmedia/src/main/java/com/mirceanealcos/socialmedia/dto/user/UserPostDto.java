package com.mirceanealcos.socialmedia.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostDto {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

}