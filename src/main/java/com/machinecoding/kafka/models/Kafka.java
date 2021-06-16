package com.machinecoding.kafka.models;

public class Kafka {
    private String name;
    private KafkaMeta kafkaMeta;

    public Kafka(String name) {
        this.name = name;
        kafkaMeta = new KafkaMeta();
    }

    public KafkaMeta getKafkaMeta() {
        return kafkaMeta;
    }
}

