package com.product_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common_masters.common.OrderDTO;
import com.product_service.models.Order;
import com.product_service.repository.OrderRepository;

@Service
public class ProductService {

  @Autowired
  private OrderRepository orderRepo;

  public void addOrder(OrderDTO req) {

    Order order = Order.builder()
        .category(req.getCategory())
        .invoiceNo(req.getInvoiceNo())
        .productName(req.getProductName())
        .quantity(req.getQuantity())
        .build();

    // orderRepo.save(req);
    System.out.println("Order saved successfully");
  }

}
