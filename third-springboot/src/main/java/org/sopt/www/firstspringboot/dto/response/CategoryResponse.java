package org.sopt.www.firstspringboot.dto.response;

import org.sopt.www.firstspringboot.entity.Category;

public record CategoryResponse(
        String category
) {
    public static CategoryResponse of(Category category){
        return new CategoryResponse(category.getContent());
    }
}
