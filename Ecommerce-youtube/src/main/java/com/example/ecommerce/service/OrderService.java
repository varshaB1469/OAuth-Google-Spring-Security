package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.Order;

public interface OrderService {
	List<Order> getAllOrders();
	Order createOrder(Order order);
	void update(Order order);

}
