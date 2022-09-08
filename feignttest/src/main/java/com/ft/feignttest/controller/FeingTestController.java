package com.ft.feignttest.controller;

import com.ft.feignttest.api.FeingTest;
import com.ft.feignttest.api.PostResponse;
import com.ft.feignttest.domain.Post;
import com.ft.feignttest.client.feing.JSONPlaceHolderClient;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ft.feignttest.api.PostResponse.fromDomain;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class FeingTestController implements FeingTest {

    Logger logger = getLogger(FeingTestController.class);

    private final JSONPlaceHolderClient jsonPlaceHolderClient;

    public FeingTestController(JSONPlaceHolderClient jsonPlaceHolderClient) {
        this.jsonPlaceHolderClient = jsonPlaceHolderClient;
    }

    public ResponseEntity<PostResponse> findPostById(Long postId) {
        logger.info("get by id");
        Post post = jsonPlaceHolderClient.getPostById(postId);
        return ok(fromDomain(post));
    }


    public ResponseEntity<List<PostResponse>> finAllPosts() {
        logger.info("get all");
        List<Post> postList = jsonPlaceHolderClient.getPosts();
        return ok(fromDomain(postList));
    }
}