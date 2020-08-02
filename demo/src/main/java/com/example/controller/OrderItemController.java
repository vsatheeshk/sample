/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.OrderItem;
import com.example.service.OrderItemService;

/**
 * @author sateesh
 *
 */
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@PostMapping("/createOrderItem")
	public ResponseEntity<HttpStatus> createOrderItem(@RequestBody OrderItem orderItem){
		
		orderItemService.createOrderItem(orderItem);
		
		return new ResponseEntity<HttpStatus>( HttpStatus.OK);
	}
	
	@GetMapping("/retrieveOrderItem")
	public ResponseEntity<List<OrderItem>> retrieveOrderItem(@PathVariable List<Long> orderIds){
		
		List<OrderItem> orderItems = orderItemService.retrieveOrderItem(orderIds);
		
		return new ResponseEntity<List<OrderItem>>(orderItems, null, HttpStatus.OK);
	}
	

}
