package org.sopt.www.firstspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.www.firstspringboot.dto.common.CustomResponse;
import org.sopt.www.firstspringboot.dto.common.Type;
import org.sopt.www.firstspringboot.dto.request.PostCreateRequest;
import org.sopt.www.firstspringboot.dto.request.PostUpdateRequest;
import org.sopt.www.firstspringboot.dto.response.PostGetResponse;
import org.sopt.www.firstspringboot.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostService postService;

    @GetMapping("{postId}")
    public CustomResponse<PostGetResponse> getPostById(@PathVariable Long postId) {
        return CustomResponse.hasData(Type.GET_POST_SUCCESS, postService.getById(postId));
    }

    @GetMapping
    public CustomResponse<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return CustomResponse.hasData(Type.GET_POST_LIST_SUCCESS, postService.getPosts(memberId));
    }

    @PostMapping
    public CustomResponse<PostGetResponse> createPost(@RequestBody PostCreateRequest request, Principal principal) {
        Long memberId = Long.valueOf(principal.getName());
        String stringId = postService.create(request, memberId);
        Long postId = Long.parseLong(stringId);
        return CustomResponse.hasData(Type.CREATE_POST_SUCCESS, postService.getById(postId));
    }

    @PatchMapping("{postId}")
    public CustomResponse<PostGetResponse> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.editContent(postId, request);
        return CustomResponse.hasData(Type.UPDATE_POST_SUCCESS, postService.getById(postId));
    }

    @DeleteMapping("{postId}")
    public CustomResponse deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return CustomResponse.noData(Type.DELETE_POST_SUCCESS);
    }
}
