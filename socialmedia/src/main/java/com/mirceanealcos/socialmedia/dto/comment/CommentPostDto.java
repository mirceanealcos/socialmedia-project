package com.mirceanealcos.socialmedia.dto.comment;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPostDto {

    @NotNull
    private String content;
    @NotNull
    private Long postId;
    @NotNull
    private Long userId;

}
