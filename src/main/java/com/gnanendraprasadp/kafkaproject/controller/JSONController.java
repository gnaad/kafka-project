package com.gnanendraprasadp.kafkaproject.controller;

import com.gnanendraprasadp.kafkaproject.entity.User;
import com.gnanendraprasadp.kafkaproject.kafka.producer.JSONProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JSONController {
    private JSONProducer jsonProducer;

    public JSONController(JSONProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonProducer.sendJson(user);
        return ResponseEntity.ok("JSON added successfully");
    }
}
