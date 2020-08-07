package com.example.demo;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.OrderItem;

@FeignClient(name="orderItem-service", url="localhost:8080")
public interface FeignProxy {
  @GetMapping("orderItem/retrieveOrderItem/{orderIds}")
  public List<OrderItem> retrieveorderItems(List<Long> orderIds);
}
