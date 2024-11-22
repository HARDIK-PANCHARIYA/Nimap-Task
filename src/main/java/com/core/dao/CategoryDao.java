package com.core.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.core.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{

}
