package com.mirceanealcos.socialmedia.dto.post;

import com.mirceanealcos.socialmedia.dto.comment.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String status;
    private String creationDate;
    private String userName;
    private Long userId;
    private List<CommentDto> comments;
}
