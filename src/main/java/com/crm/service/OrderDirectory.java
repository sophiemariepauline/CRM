package com.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.OrderRepository;
import com.crm.model.Order;

@Service
public class OrderDirectory {

	@Autowired
	private OrderRepository orderRepository;
	
	public void addOrder(Order newOrder) {

		orderRepository.save(newOrder);
	}
	
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}

	public Optional<Order> getOrder(Long id) {
		return orderRepository.findById(id);
	}

	public void deleteOrder(Long id){
		orderRepository.deleteById(id);
	}

	public void updateOrder(Order orderToUpdate){
		orderRepository.save(orderToUpdate);
	}
}