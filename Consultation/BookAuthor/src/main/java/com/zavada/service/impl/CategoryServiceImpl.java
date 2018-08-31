package com.zavada.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zavada.domain.CategoryDTO;
import com.zavada.entity.BookEntity;
import com.zavada.entity.CategoryEntity;
import com.zavada.repository.CategoryRepository;
import com.zavada.service.CategoryService;
import com.zavada.service.utils.ObjectMapperUtils;
import com.zavada.service.utils.StringUtils;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ObjectMapperUtils objectMapper;

	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void create(CategoryDTO category) {
		String categoryId = stringUtils.generate();
		if(!categoryRepository.existsByCategoryId(categoryId)) {
			category.setCategoryId(categoryId);
			categoryRepository.save(objectMapper.map(category, CategoryEntity.class));
		} else {
			
		}
	}

	@Override
	public CategoryDTO get(String categoryId) {
		return objectMapper.map(categoryRepository.findByCategoryId(categoryId), CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAll() {
		return objectMapper.mapAll(categoryRepository.findAll(), CategoryDTO.class);
	}
	
	
}
