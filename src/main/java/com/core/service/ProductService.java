package com.core.service;

import org.springframework.data.domain.Page;
import com.core.entity.Product;
import com.core.exception.ResourceNotFoundException;

public interface ProductService {
	Product createProduct(Product product);

	Page<Product> getAllProducts(int page, int size);

	Product getProductById(long id) throws ResourceNotFoundException;;

	Product updateProduct(long id, Product productDetails) throws ResourceNotFoundException;;

	void deleteProduct(long id) throws ResourceNotFoundException;;


}
