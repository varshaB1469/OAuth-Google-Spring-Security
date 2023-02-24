package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
