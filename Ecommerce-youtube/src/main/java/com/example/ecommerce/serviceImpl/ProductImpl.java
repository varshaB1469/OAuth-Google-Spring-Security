package com.example.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.ResourceNotFoundException;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repositories.ProductRepo;
import com.example.ecommerce.service.ProductService;


@Service
public class ProductImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer productId) {
		Product product = this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		return product;
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

}
