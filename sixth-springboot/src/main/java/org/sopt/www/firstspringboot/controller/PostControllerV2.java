package org.sopt.www.firstspringboot.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.www.firstspringboot.dto.common.CustomResponse;
import org.sopt.www.firstspringboot.dto.common.Type;
import org.sopt.www.firstspringboot.dto.request.PostCreateRequest;
import org.sopt.www.firstspringboot.dto.response.PostGetResponse;
import org.sopt.www.firstspringboot.service.PostServiceV2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v2/posts")
@RequiredArgsConstructor
public class PostControllerV2 {
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostServiceV2 postService;

    @PostMapping
    public CustomResponse<PostGetResponse> createPostV2(@RequestHeader(CUSTOM_AUTH_ID) Long memberId, @RequestPart MultipartFile image, PostCreateRequest request) {
        String stringId = postService.createV2(request, image, memberId);
        Long postId = Long.parseLong(stringId);
        return CustomResponse.hasData(Type.CREATE_POST_SUCCESS, postService.getByIdV2(postId));
    }

    @DeleteMapping("{postId}")
    public CustomResponse deletePost(@PathVariable Long postId) {
        postService.deleteByIdV2(postId);
        return CustomResponse.noData(Type.DELETE_POST_SUCCESS);
    }
}