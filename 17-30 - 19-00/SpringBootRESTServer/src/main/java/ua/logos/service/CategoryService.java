package ua.logos.service;

import java.util.List;

import ua.logos.domain.CategoryDTO;

public interface CategoryService {

	void saveCategory(CategoryDTO dto);
	
	CategoryDTO findCategoryById(Long id);
	
	List<CategoryDTO> findAllCategories();
}
