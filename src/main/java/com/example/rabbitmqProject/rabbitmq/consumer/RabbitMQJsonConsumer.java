package com.example.rabbitmqProject.rabbitmq.consumer;

import com.example.rabbitmqProject.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    // rabbitmq internally convert json to java object
    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consumeJsonMessage(User user) {
        LOGGER.info(String.format("Message received -> %s", user.toString()));
    }
}
