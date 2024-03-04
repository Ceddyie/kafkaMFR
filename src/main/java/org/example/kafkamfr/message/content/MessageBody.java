package org.example.kafkamfr.message.content;

import lombok.Data;

@Data
public class MessageBody {
    private String subSystem;
    private long timestamp;

    MessageBody(){}

    public MessageBody(String subSystem, long timestamp) {
        this.subSystem = subSystem;
        this.timestamp = timestamp;
    }
}
