package com.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.core.dao.CategoryDao;
import com.core.dao.ProductDao;
import com.core.entity.Product;
import com.core.exception.ResourceNotFoundException;
import com.core.entity.Category;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductDao productDao;
    private final CategoryDao categoryDao;

    
    public ProductServiceImpl(ProductDao productDao, CategoryDao categoryDao) {
	this.productDao = productDao;
	this.categoryDao = categoryDao;
}
    
    @Override
    public Product createProduct(Product product) {
        // Ensure category exists in the database
        long categoryId = product.getCategory().getCId();
        Category existingCategory = categoryDao.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));

        // Set the managed category object
        product.setCategory(existingCategory);

        // Save product
        return productDao.save(product);
    }

	@Override
    public Page<Product> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productDao.findAll(pageable);
    }
    
    @Override
    public Product getProductById(long id) throws ResourceNotFoundException {
        return productDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(long id, Product productDetails) throws ResourceNotFoundException {
        // Fetch the existing product
        Product existingProduct = productDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        // Update product details
        existingProduct.setPName(productDetails.getPName());
        existingProduct.setPrice(productDetails.getPrice());

        // Handle the category update
        if (productDetails.getCategory() != null && productDetails.getCategory().getCId() != null) {
            long categoryId = productDetails.getCategory().getCId();
            Category category = categoryDao.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
            existingProduct.setCategory(category);
        }

        // Save and return the updated product
        return productDao.save(existingProduct);
    }
    
    @Override
    public void deleteProduct(long id) throws ResourceNotFoundException {
        Product product = productDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        productDao.delete(product);
    }

}
