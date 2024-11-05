package com.mirceanealcos.socialmedia.util.mapper;

import com.mirceanealcos.socialmedia.dto.comment.CommentDto;
import com.mirceanealcos.socialmedia.entity.Comment;
import com.mirceanealcos.socialmedia.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class CommentDtoMapper {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static CommentDto toCommentDto(Comment comment) {
        if (comment == null) {
            return null;
        }
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setCreationDate(dateFormat.format(comment.getCreationDate()));
        commentDto.setPostId(comment.getPost().getId());
        commentDto.setUserId(comment.getUser().getId());
        return commentDto;
    }


}
