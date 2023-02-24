package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
