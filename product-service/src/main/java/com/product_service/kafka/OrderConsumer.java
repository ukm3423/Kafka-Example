package com.product_service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.common_masters.common.Order;


@Service
public class OrderConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

  @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(Order event) {

    LOGGER.info(String.format("\n\nProduct-Service received order event => %s ", event.toString()));

    


  }

}
