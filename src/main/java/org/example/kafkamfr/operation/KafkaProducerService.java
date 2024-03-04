package org.example.kafkamfr.operation;

import org.example.kafkamfr.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String MFR_MESSAGE = "mfr_message";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Message message) {
        kafkaTemplate.send(MFR_MESSAGE, message);
    }
}