package com.ft.feignttest.api;

import com.ft.feignttest.domain.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostResponse {

    private Integer id;
    private String title;
    private String body;
    private String userId;

    public PostResponse(
            Integer id,
            String title,
            String body,
            String userId
    ) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {
        return userId;
    }

    public static PostResponse fromDomain(Post post){
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getBody(),
                post.getUserId()
        );
    }

    public static List<PostResponse> fromDomain(List<Post> postList){
        return postList.stream()
                .map( p -> fromDomain(p))
                .collect(Collectors.toList());
    }
}