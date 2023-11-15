package org.sopt.www.firstspringboot.repository;

import org.sopt.www.firstspringboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
}
