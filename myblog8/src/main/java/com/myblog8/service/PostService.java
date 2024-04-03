package com.myblog8.service;

import com.myblog8.payload.PostDto;

import java.util.List;

public interface PostService {

    public PostDto createPost(PostDto post);

    void deletePostById(int postId);

    PostDto getPostByPostId(int postId);

    List<PostDto> getAllPosts();
}
