package com.core.service;

import org.springframework.data.domain.Page;

import com.core.entity.Category;
import com.core.exception.ResourceNotFoundException;

public interface CategoryService {

	Category createCategory(Category category);

	Page<Category> getAllCategories(int page, int size);

	Category getCategoryById(long id) throws ResourceNotFoundException;

	Category updateCategory(long id, Category categoryDetails) throws ResourceNotFoundException;

	void deleteCategory(long id) throws ResourceNotFoundException;

}
