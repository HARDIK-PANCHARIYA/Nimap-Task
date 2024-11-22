package com.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
