package com.example.demo;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.OrderItem;

@FeignClient(name="orderItem-service", url="http://localhost:8080")
public interface FeignProxy {
  @GetMapping("/orderItem/retrieveOrderItem")
  public List<OrderItem> retrieveorderItems();
}
