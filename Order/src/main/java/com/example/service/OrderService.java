/**
 * 
 */
package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.FeignProxy;
import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.OrderRepository;

/**
 * @author sateesh
 *
 */
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	FeignProxy feignProxy;

	public void createOrder(Order order) {
		
		orderRepository.save(order);
	}

	public Order retrieveOrder() throws ResourceNotFoundException {
		
		Optional<List<Order>> order = Optional.of(orderRepository.findAll());
		
		if (!order.isPresent())
		      throw new ResourceNotFoundException("Order is not available");
		
		Order actualOrder = order.get().get(0);
		
		List<OrderItem> response = feignProxy.retrieveorderItems();

		actualOrder.setOrderItems(response);
		return actualOrder;
		
	}

}
