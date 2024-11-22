package com.core.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.core.dao.CategoryDao;
import com.core.dao.ProductDao;
import com.core.entity.Category;
import com.core.entity.Product;

@Component
@Configuration
public class Data {

	@Bean
	public CommandLineRunner initData(CategoryDao categoryDao, ProductDao productDao) {
		return args -> {

			// Check if data already exists
			if (categoryDao.count() > 0 && productDao.count() > 0) {
				System.out.println("Data already exists. Skipping initialization.");
				return;
			} else {
				// Creating Categories
				Category electronics = categoryDao.save(new Category("Electronics"));
				Category stationery = categoryDao.save(new Category("Stationery"));
				Category clothing = categoryDao.save(new Category("Clothing"));
				Category furniture = categoryDao.save(new Category("Furniture"));
				Category sports = categoryDao.save(new Category("Sports"));

				// Creating Products
				productDao.save(new Product("Smartphone", 5464.99, electronics));
				productDao.save(new Product("Laptop", 40500.99, electronics));
				productDao.save(new Product("Tablet", 34556.659, electronics));

				productDao.save(new Product("NoteBook", 194.99, stationery));
				productDao.save(new Product("Pen", 29.99, stationery));

				productDao.save(new Product("T-Shirt", 19.99, clothing));
				productDao.save(new Product("Jeans", 49.99, clothing));

				productDao.save(new Product("Table", 199.99, furniture));
				productDao.save(new Product("Chair", 149.99, furniture));

				productDao.save(new Product("Football", 24.99, sports));
				productDao.save(new Product("Bat", 89.99, sports));

			}

		};
	}
}