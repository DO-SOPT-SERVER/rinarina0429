package org.sopt.www.firstspringboot.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.www.firstspringboot.dto.response.CategoryResponse;
import org.sopt.www.firstspringboot.entity.Category;
import org.sopt.www.firstspringboot.entity.CategoryId;
import org.sopt.www.firstspringboot.repository.CategoryJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryJpaRepository categoryJpaRepository;
    public Category getByCategoryId(CategoryId categoryId) {
        return categoryJpaRepository.findByIdOrThrow(Short.valueOf(categoryId.getCategoryId()));
    }
    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryJpaRepository.findByIdOrThrow(id));
    }
}
