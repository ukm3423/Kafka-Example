package com.product_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_orders")
public class Order {
  private Long id; 
  private String invoiceNo; 
  private String productName; 
  private Double price; 
  private Integer quantity;
  private String category;

}
