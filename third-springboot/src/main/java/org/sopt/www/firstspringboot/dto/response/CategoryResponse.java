package org.sopt.www.firstspringboot.dto.response;

import org.sopt.www.firstspringboot.entity.Category;
import org.sopt.www.firstspringboot.entity.Post;

public record CategoryResponse(
        Short id,
        String content
) {
    public static CategoryResponse of(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getContent()
        );
    }
}
