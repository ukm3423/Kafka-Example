package com.order_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common_masters.common.Order;
import com.order_service.kafka.OrderProducer;

@Service
public class OrderService {

  @Autowired
  private OrderProducer orderProducer;

  public String placeOrder(Order order) {
    orderProducer.sendMessage(order);
    System.out.println("Order placed successfully");
    return "Order placed successfully";
  }
  
}
