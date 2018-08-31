package com.zavada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zavada.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findByCategoryId(String categoryId);
	
	boolean existsByCategoryId(String categoryId);
}
