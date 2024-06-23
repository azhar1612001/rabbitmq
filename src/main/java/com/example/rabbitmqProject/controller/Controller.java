package com.example.rabbitmqProject.controller;

import com.example.rabbitmqProject.dto.Pojo;
import com.example.rabbitmqProject.dto.User;
import com.example.rabbitmqProject.rabbitmq.producer.RabbitMQJsonProducer;
import com.example.rabbitmqProject.rabbitmq.producer.RabbitMQProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final RabbitMQProducer rabbitMQProducer;

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    Controller(RabbitMQProducer rabbitMQProducer, RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<Object> healthCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/pojo")
    public ResponseEntity<Pojo> funtion(@RequestBody Pojo pojo) {
        Pojo response = new Pojo();
        response.setName("name");
        response.setUsername("username");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return new ResponseEntity<>("Message sent", HttpStatus.OK);
    }

    @PostMapping("/sendJsonMessage")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return new ResponseEntity<>("Json Message has sent", HttpStatus.OK);
    }
}
