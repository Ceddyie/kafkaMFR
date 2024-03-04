package org.example.kafkamfr.Message;

import lombok.Data;
import org.example.kafkamfr.Message.content.MessageBody;
import org.example.kafkamfr.Message.content.MessageHead;

@Data
public class Message {
    private MessageHead head;
    private MessageBody body;

    Message() {}

    Message(MessageHead messageHead, MessageBody messageBody) {
        this.head= messageHead;
        this.body= messageBody;
    }
}
