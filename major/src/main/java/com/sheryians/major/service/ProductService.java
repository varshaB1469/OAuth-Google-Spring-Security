package com.sheryians.major.service;

import com.sheryians.major.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(Product product);

    void deleteProduct(Long productId);

    Optional<Product> getProduct(Long productId);

    List<Product> getProductByCategoryId(Integer categoryId);

}
