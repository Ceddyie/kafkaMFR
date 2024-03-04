package org.example.kafkamfr.message;

import lombok.Data;
import org.example.kafkamfr.message.content.MessageBody;
import org.example.kafkamfr.message.content.MessageHead;

@Data
public class Message {
    private MessageHead head;
    private MessageBody body;

    public Message(MessageHead head, MessageBody body) {
        this.head= head;
        this.body= body;
    }
}
