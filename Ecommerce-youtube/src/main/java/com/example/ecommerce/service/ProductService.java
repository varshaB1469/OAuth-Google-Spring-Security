package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(Integer productId);
	Product save(Product product);

}
