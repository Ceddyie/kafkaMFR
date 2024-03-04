package org.example.kafkamfr.Message.content;

import lombok.Data;

@Data
public class MessageHead {
    private int version;
    private String identifier;
    private String mode;

    MessageHead(){}

    MessageHead(int version, String identifier, String mode) {
        this.version = version;
        this.identifier = identifier;
        this.mode = mode;
    }
}
