package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.CategoryDTO;
import ua.logos.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

	
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<Void> createCategory(
			@RequestBody CategoryDTO categoryDTO) {
		categoryService.create(categoryDTO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<CategoryDTO> categoryDTOs = categoryService.findAll();
		return new ResponseEntity<List<CategoryDTO>>(categoryDTOs, HttpStatus.OK);
	}
	
	
}