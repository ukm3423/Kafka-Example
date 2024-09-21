package com.product_service.handler;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product_service.repository.OrderRepository;

@Component
public class Generator {

  private static OrderRepository orderRepo;

  @Autowired
  public Generator(OrderRepository orderRepo) {
    this.orderRepo = orderRepo;
  }

  // ======================= Invoice Number Generator =================================

  public static String generateInvoiceNumber() {
    String orderNumber;
    do {
      orderNumber = generateRandomOrderNumber();
    } while (!isorderNumberUnique(orderNumber));
    return orderNumber;
  }

  private static String generateRandomOrderNumber() {
    Random random = new Random();
    // You can adjust the length of the random number as needed
    String randomNumber = String.format("%010d", random.nextInt(1000000));
    return "INV" + randomNumber;
  }

  private static boolean isorderNumberUnique(String orderNumber) {
    return orderRepo.findByInvoiceNo(orderNumber) == null;
  }
}
