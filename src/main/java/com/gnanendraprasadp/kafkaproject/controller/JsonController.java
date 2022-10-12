package com.gnanendraprasadp.kafkaproject.controller;

import com.gnanendraprasadp.kafkaproject.entity.User;
import com.gnanendraprasadp.kafkaproject.kafka.producer.JsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonController {
    private JsonProducer jsonProducer;

    public JsonController(JsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> getMessage(@RequestBody User user){
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent successfully");
    }
}
