package com.ft.feignttest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/posts")
public interface FeingTest {

    @GetMapping("/{postId}")
    ResponseEntity<PostResponse> findPostById(@PathVariable("postId") Long postId);

    @GetMapping("/all")
    ResponseEntity<List<PostResponse>> finAllPosts();

}
