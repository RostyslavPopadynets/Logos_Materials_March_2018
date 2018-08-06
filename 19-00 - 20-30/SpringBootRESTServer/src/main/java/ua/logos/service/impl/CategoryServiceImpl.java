package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.CategoryDTO;
import ua.logos.entity.CategoryEntity;
import ua.logos.repository.CategoryRepository;
import ua.logos.service.CategoryService;
import ua.logos.service.utils.ObjectMapperUtils;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void create(CategoryDTO dto) {
		CategoryEntity categoryEntity = 
				modelMapper.map(dto, CategoryEntity.class);
		categoryRepository.save(categoryEntity);
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> categoryEntities = 
				categoryRepository.findAll();
		
		List<CategoryDTO> categoryDTOs = 
				modelMapper.mapAll(categoryEntities, CategoryDTO.class);
		
		return categoryDTOs;
	}

	@Override
	public CategoryDTO findOne(Long id) {
		CategoryEntity categoryEntity = 
				categoryRepository.findById(id).get();
		CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);
		return categoryDTO;
	}

}
