package org.sopt.www.firstspringboot.dto.request;

import org.sopt.www.firstspringboot.entity.CategoryId;

public record PostCreateRequest (
        String title,
        String content,
        String category
) {
}
