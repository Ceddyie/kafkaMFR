package org.example.kafkamfr.operation;

import org.example.kafkamfr.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String MFR_MESSAGE = "mfr_message";
    private static final String MFR_OBJECT = "mfr_object";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Object> objectKafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(MFR_MESSAGE, message);
    }

    public void sendObject(Message messageObject) {
        objectKafkaTemplate.send(MFR_OBJECT, messageObject);
    }
}
