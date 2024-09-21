package com.common_masters.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

  private String invoiceNo;
  private String productName;
  private Double price;
  private Integer quantity;
  private String category;
  
}
