package org.example.kafkamfr.operation;

import org.example.kafkamfr.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/sendMessage")
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody Message message) {
        producerService.sendMessage(message);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Message sent");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
