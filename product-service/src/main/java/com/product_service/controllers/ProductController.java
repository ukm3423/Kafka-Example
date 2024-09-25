package com.product_service.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.models.Order;
import com.product_service.services.ProductService;

@RestController
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @GetMapping("order-list")
  public ResponseEntity<Map<String, Object>> getList(){
   
    List<Order> list = productService.getOrderList(); 

    Map<String, Object> resp = new HashMap<>();
    resp.put("data", list);
    resp.put("message", "Order list retrieved successfully");
    resp.put("status", true);

    return ResponseEntity.status(HttpStatus.OK).body(resp);

  }

}
