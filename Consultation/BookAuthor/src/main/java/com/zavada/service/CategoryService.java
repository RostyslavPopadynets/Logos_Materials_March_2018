package com.zavada.service;

import java.util.List;

import com.zavada.domain.CategoryDTO;

public interface CategoryService {

	void create(CategoryDTO category);
	
	CategoryDTO get(String categoryId);
	
	List<CategoryDTO> getAll();
}
