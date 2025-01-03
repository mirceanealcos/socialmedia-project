package com.mirceanealcos.socialmedia.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String content;
    private String creationDate;
    private String userName;
    private String postTitle;
    private Long userId;

}
