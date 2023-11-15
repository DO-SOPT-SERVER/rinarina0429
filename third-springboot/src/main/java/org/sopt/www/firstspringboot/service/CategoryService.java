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
        return categoryJpaRepository.findById(Short.valueOf(categoryId.getCategoryId())).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
    }
    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다.")));
    }
}
