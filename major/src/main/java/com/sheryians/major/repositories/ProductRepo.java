package com.sheryians.major.repositories;

import com.sheryians.major.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory_Id(Integer categoryId);
}
