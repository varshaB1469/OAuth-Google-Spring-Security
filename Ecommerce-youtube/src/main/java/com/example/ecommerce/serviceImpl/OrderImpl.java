package com.example.ecommerce.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.repositories.OrderRepo;
import com.example.ecommerce.service.OrderService;


@Service
public class OrderImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;;

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order createOrder(Order order) {
		order.setDateCreated(LocalDate.now());
		return this.orderRepo.save(order);
	}

	@Override
	public void update(Order order) {
		this.orderRepo.save(order);

	}

}
