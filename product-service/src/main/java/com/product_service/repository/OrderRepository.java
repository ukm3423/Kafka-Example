package com.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product_service.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

  Order findByInvoiceNo(String invoiceNo);
  
}
