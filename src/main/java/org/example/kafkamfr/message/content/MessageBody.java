package org.example.kafkamfr.message.content;

import lombok.Data;

@Data
public class MessageBody {
    private String subsystem;
    private long timestamp;

    MessageBody(){}

    public MessageBody(String subsystem, long timestamp) {
        this.subsystem = subsystem;
        this.timestamp = timestamp;
    }
}
