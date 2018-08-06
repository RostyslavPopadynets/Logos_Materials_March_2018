package ua.logos.service;

import java.util.List;

import ua.logos.domain.CategoryDTO;

public interface CategoryService {

	void create(CategoryDTO dto);
	
	List<CategoryDTO> findAll();
	
	CategoryDTO findOne(Long id);
}
