package com.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.model.Order;
import com.crm.service.OrderDirectory;



@RestController
@RequestMapping("api")
public class OrderController {
	
	@Autowired
	private OrderDirectory orderDirectory;
	
	@GetMapping("orders")
	public List<Order> getOrders(){
		
		return orderDirectory.getOrders();
	}


	@PostMapping("orders")
	public Order postOrder(@RequestBody Order newOrder) {
		orderDirectory.addOrder(newOrder);		
		return newOrder;
	}

	@DeleteMapping("orders/{id}")
	public void deleteOrder(@PathVariable("id") Long id){
		orderDirectory.deleteOrder(id);
	}

	@PutMapping("orders/{id}")
	public ResponseEntity updateOrder(@RequestBody Order order, @PathVariable("id") Long id){

		if(id != order.getId()){
			return ResponseEntity.badRequest().build();
		}
		else {

			orderDirectory.updateOrder(order);
			return ResponseEntity.ok().build();
		}
	}
}