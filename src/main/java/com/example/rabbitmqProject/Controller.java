package com.example.rabbitmqProject;

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

    private RabbitMQProducer rabbitMQProducer;

    Controller(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
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
}
