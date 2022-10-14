package com.gnanendraprasadp.kafkaproject.controller;

import com.gnanendraprasadp.kafkaproject.kafka.producer.PremiumProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PremiumController {
    private PremiumProducer premiumProducer;

    public PremiumController(PremiumProducer premiumProducer) {
        this.premiumProducer = premiumProducer;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        premiumProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
