package org.example.kafkamfr.Message.content;

import lombok.Data;

@Data
public class MessageBody {
    private String subSystem;
    private long timestamp;

    MessageBody(){}

    MessageBody(String subSystem, long timestamp) {
        this.subSystem = subSystem;
        this.timestamp = timestamp;
    }
}
