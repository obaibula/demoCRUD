package com.example.demoCRUD.rest;

import com.example.demoCRUD.entity.Post;
import com.example.demoCRUD.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/api")
public class PostRestController {
    private PostService postService;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable int postId){
        return requireNonNull(postService.findById(postId), "Post not found");
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post){
        requireNonNull(post);
        post.setId(0);
        return postService.save(post);
    }

    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post post){
        return postService.save(requireNonNull(post, "post not found"));
    }

    @DeleteMapping("/posts/{postId}")
    public String deletePostById(@PathVariable int postId){
        requireNonNull(postService.findById(postId));
        postService.deletebyId(postId);
        return "deleted post with id - " + postId;
    }
}
