package com.machinecoding.kafka.client;

import com.machinecoding.kafka.services.KafkaService;

public class SubscriberService {

    private KafkaService kafkaService;

    public SubscriberService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public String pull(String groupId, String topicName) {
        String message = kafkaService.pull(topicName, groupId);
        return message;
    }
}
