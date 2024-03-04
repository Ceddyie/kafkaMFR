package org.example.kafkamfr.operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kafkamfr.message.Message;
import org.example.kafkamfr.message.content.MessageBody;
import org.example.kafkamfr.message.content.MessageHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerComponent {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private KafkaProducerService producerService;

    @KafkaListener(topics = "mfr_message")
    public void listen(String message) {
        message = message.replace("\"", "");
        System.out.println(message);

        MessageHead head = new MessageHead(Integer.parseInt(message.substring(0,2)), message.substring(2,4), message.substring(4,6));
        MessageBody body = new MessageBody(message.substring(6,8), Long.parseLong(message.substring(8)));

        Message messageObject = new Message(head, body);

        System.out.println(messageObject);

        producerService.sendObject(messageObject);
    }

    @KafkaListener(topics = "mfr_object")
    public void listenObject(String object) throws JsonProcessingException {
        Message message = mapper.readValue(object, Message.class);
        System.out.println(message);
    }
}
