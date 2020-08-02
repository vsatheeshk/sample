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

	public Order retrieveOrder(Long orderId) throws ResourceNotFoundException {
		
		Optional<Order> order = orderRepository.findById(orderId);
		
		if (!order.isPresent())
		      throw new ResourceNotFoundException("Order is not available");
		
		Order actualOrder = order.get();
		List<OrderItem> orderIds = actualOrder.getOrderItems();
		ResponseEntity<Object> responseEntity = new RestTemplate().getForEntity(
		        "http://localhost:8000/orderItem/retrieveOrderItem/{orderIds}", Object.class,
		        orderIds);

		List<OrderItem> response = (List<OrderItem>) responseEntity.getBody();
		actualOrder.setOrderItems(response);
		return actualOrder;
		
	}

}
