package com.product_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common_masters.common.OrderDTO;
import com.product_service.handler.Generator;
import com.product_service.models.Order;
import com.product_service.repository.OrderRepository;

@Service
public class ProductService {

  @Autowired
  private OrderRepository orderRepo;

  public Order addOrder(OrderDTO req) {

    String invoiceNo = Generator.generateInvoiceNumber();

    Order order = Order.builder()
        .category(req.getCategory())
        .invoiceNo(invoiceNo)
        .productName(req.getProductName())
        .quantity(req.getQuantity())
        .price(req.getPrice())
        .build();

    System.out.println("Order saved successfully");

    return orderRepo.save(order);
  }

}
