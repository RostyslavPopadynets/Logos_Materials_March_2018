package com.zavada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zavada.domain.CategoryDTO;
import com.zavada.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Void> addCategory(@RequestBody CategoryDTO category) {
		categoryService.create(category);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getCategories() {
		return new ResponseEntity<List<CategoryDTO>>(categoryService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("{categoryId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable("categoryId") String categoryId) {
		return new ResponseEntity<CategoryDTO>(categoryService.get(categoryId), HttpStatus.OK);
	}
	
}
