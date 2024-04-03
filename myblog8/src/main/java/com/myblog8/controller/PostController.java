package com.myblog8.controller;

import com.myblog8.payload.PostDto;
import com.myblog8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired //This annotation is used for automatic dependency injection.
    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    //http://localhost:8080/api/posts

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts/{postId}

//    Delete Blog
    @DeleteMapping("{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable int postId){
        postService.deletePostById(postId);
        return new ResponseEntity<>("Post is deleted with Id: "+postId, HttpStatus.OK);
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> getPostByPostId(@PathVariable int postId){
        PostDto dto = postService.getPostByPostId(postId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
       List<PostDto> postDtos =  postService.getAllPosts();
       return postDtos;
    }
}
