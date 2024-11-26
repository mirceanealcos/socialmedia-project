package com.mirceanealcos.socialmedia.service;

import com.mirceanealcos.socialmedia.dto.post.PostAddDto;
import com.mirceanealcos.socialmedia.dto.post.PostDto;
import com.mirceanealcos.socialmedia.dto.post.PostUpdateDto;

import java.util.List;

public interface PostService {

    PostDto findById(Long id);
    PostDto addPost(PostAddDto postAddDto);
    void deleteById(Long id);
    PostDto updatePost(Long id, PostUpdateDto postAddDto);
    List<PostDto> findPublishedPostsByUserId(Long userId);
    List<PostDto> findPendingPostsByUserId(Long userId);
    List<PostDto> findAllPublishedPosts();
    List<PostDto> findByKeyword(String keyword);
    List<PostDto> findAllPendingPosts();
    void approvePost(Long id);

}
