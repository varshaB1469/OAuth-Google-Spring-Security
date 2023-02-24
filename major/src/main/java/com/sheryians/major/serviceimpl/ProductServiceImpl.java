package com.sheryians.major.serviceimpl;

import com.sheryians.major.model.Product;
import com.sheryians.major.repositories.CategoryRepo;
import com.sheryians.major.repositories.ProductRepo;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;



    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productRepo.findById(productId);
    }

    @Override
    public List<Product> getProductByCategoryId(Integer categoryId) {
        return productRepo.findAllByCategory_Id(categoryId);
    }


}
