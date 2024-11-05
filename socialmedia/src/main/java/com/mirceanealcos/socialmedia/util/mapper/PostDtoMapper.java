package com.mirceanealcos.socialmedia.util.mapper;

import com.mirceanealcos.socialmedia.dto.post.PostAddDto;
import com.mirceanealcos.socialmedia.dto.post.PostDto;
import com.mirceanealcos.socialmedia.entity.Post;

import java.text.SimpleDateFormat;

public class PostDtoMapper {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static PostDto toPostDto(Post post) {
        if (post == null) {
            return null;
        }
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setStatus(post.getStatus().name());
        postDto.setCreationDate(dateFormat.format(post.getCreationDate()));
        postDto.setUserId(post.getUser().getId());
        return postDto;
    }

    public static Post toPostForAdd(PostAddDto postAddDto) {
        if (postAddDto == null) {
            return null;
        }
        Post post = new Post();
        post.setTitle(postAddDto.getTitle());
        post.setContent(postAddDto.getContent());
        return post;
    }

}
