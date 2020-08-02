/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.exception.ResourceNotFoundException;
import com.example.service.OrderService;

/**
 * @author sateesh
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/createOder")
	public ResponseEntity<HttpStatus> createOrder(@RequestBody Order order){
		
		orderService.createOrder(order);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("/retrieveOrder")
	public ResponseEntity<Order> retrieveOrder(@PathVariable Long orderId) throws ResourceNotFoundException{
		
		Order order = orderService.retrieveOrder(orderId);
		return new ResponseEntity<Order>(order, null,HttpStatus.OK);	
		
	}

}
