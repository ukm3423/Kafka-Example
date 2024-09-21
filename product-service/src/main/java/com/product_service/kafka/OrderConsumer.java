package com.product_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.common_masters.common.OrderDTO;
import com.product_service.models.Order;
import com.product_service.services.ProductService;


@Service
public class OrderConsumer {

  @Autowired
  private ProductService orderService;

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

  @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(OrderDTO event) {

    LOGGER.info(String.format("\n\nProduct-Service received order event => %s ", event.toString()));

    Order resp  = orderService.addOrder(event);
    LOGGER.info("Order placed successfully in Order-Service: " + resp);



  }

}
