/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.OrderItem;
import com.example.repository.OrderItemRepository;

/**
 * @author sateesh
 *
 */
@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	public void createOrderItem(OrderItem orderItem){
		
		orderItemRepository.save(orderItem);
//		return null;
	}
	
	public List<OrderItem> retrieveOrderItem(){
		
		return orderItemRepository.findAll();
	}
	
	
	
}
