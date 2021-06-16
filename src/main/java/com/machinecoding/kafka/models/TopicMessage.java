package com.machinecoding.kafka.models;

import org.joda.time.DateTime;

public class TopicMessage {

    private String message;
    private DateTime expiredTimestamp;
    private long offset;

    public TopicMessage(String message, DateTime expiredTimestamp){
        this.message = message;
        this.expiredTimestamp = expiredTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }
}

