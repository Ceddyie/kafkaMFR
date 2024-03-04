package org.example.kafkamfr.operation;

import org.apache.commons.lang3.StringUtils;
import org.example.kafkamfr.message.Message;
import org.example.kafkamfr.message.content.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class Controller {
    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/sendMessage")
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody Message message) {
        MessageBody body = message.getBody();
        LocalDateTime dateTime = LocalDateTime.now();
        body.setTimestamp(Long.parseLong(dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"))));
        message.setBody(body);

        String version = StringUtils.leftPad(String.valueOf(message.getHead().getVersion()), 2, "0");
        String identifier = message.getHead().getIdentifier();
        String mode = message.getHead().getMode();

        String subsystem = message.getBody().getSubsystem();
        String timestamp = StringUtils.leftPad(String.valueOf(message.getBody().getTimestamp()), 12, "0");

        String telegramMessage = version + identifier + mode + subsystem + timestamp;

        System.out.println(telegramMessage);

        producerService.sendMessage(telegramMessage);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Message sent");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
