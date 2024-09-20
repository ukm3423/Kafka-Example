package com.order_service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.common_masters.common.Order;
import com.common_masters.model.Product;


@Service
public class OrderProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Autowired
    private NewTopic topic;

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;
  
    public void sendMessage(Order event) {
        LOGGER.info(String.format("\nOrderService Send to the ProductService => %s", event.toString()));

        // CREATING MESSAGE
        Message<Order> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);

    }

}
