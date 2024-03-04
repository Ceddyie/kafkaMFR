package org.example.kafkamfr.operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kafkamfr.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerComponent {
    @Autowired
    private ObjectMapper mapper;

    @KafkaListener(topics = "mfr_message")
    public void listen(String message) {
        try {
            System.out.println(String.format("##########\nConsumed Message-> %s\n##########", message));
            Message receivedMessage = mapper.readValue(message, Message.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
