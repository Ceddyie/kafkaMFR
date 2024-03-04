package org.example.kafkamfr.message.content;

import lombok.Data;

@Data
public class MessageHead {
    private int version;
    private String identifier;
    private String mode;

    public MessageHead(int version, String identifier, String mode) {
        this.version = version;
        this.identifier = identifier;
        this.mode = mode;
    }
}
