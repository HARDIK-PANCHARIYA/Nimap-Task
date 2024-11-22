package com.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.core.dao.CategoryDao;
import com.core.entity.Category;
import com.core.exception.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryDao categorydao;
	
	public CategoryServiceImpl(CategoryDao categorydao) {
        this.categorydao = categorydao;
    }

    @Override
    public Category createCategory(Category category) {
        return categorydao.save(category);
    }

    @Override
    public Page<Category> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return categorydao.findAll(pageable);
    }
    
    @Override
    public Category getCategoryById(long id) throws ResourceNotFoundException {
        return categorydao.findById(id).
        		orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
    }

    @Override
    public Category updateCategory(long id, Category categoryDetails) throws ResourceNotFoundException {
        Category category = categorydao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));

        category.setCName(categoryDetails.getCName());
        return categorydao.save(category);
    }

    @Override
    public void deleteCategory(long id) throws ResourceNotFoundException {
        Category category = categorydao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));

        categorydao.delete(category);
    }

}
