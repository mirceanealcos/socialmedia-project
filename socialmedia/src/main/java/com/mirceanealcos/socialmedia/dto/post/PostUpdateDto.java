package com.mirceanealcos.socialmedia.dto.post;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateDto {
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String status;
}
