package org.sopt.www.firstspringboot.dto.response;

import org.sopt.www.firstspringboot.entity.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content
) {
    public static PostGetResponse of(Post post){
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent()
        );
    }
}
