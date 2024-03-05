package org.example.kafkamfr.operation;

import org.apache.commons.lang3.StringUtils;
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

    public void sendObject(Message response) {
        String version = StringUtils.leftPad(String.valueOf(response.getHead().getVersion()), 2, "0");
        String identifier = response.getHead().getIdentifier();
        String mode = response.getHead().getMode();

        String subsystem = response.getBody().getSubsystem();
        String timestamp = StringUtils.rightPad(String.valueOf(response.getBody().getTimestamp()), 12, "0");

        String telegramMessage = version + identifier + mode + subsystem + timestamp;

        System.out.println(telegramMessage);
        kafkaTemplate.send(MFR_OBJECT, telegramMessage);
    }
}
