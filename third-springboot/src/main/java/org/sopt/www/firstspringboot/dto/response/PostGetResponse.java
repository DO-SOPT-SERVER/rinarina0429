package org.sopt.www.firstspringboot.dto.response;

import org.sopt.www.firstspringboot.entity.Category;
import org.sopt.www.firstspringboot.entity.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        String category
) {
    public static PostGetResponse of(Post post, Category category) {
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                category.getContent()
        );
    }
}
