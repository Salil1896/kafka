package com.machinecoding.kafka.client;

import com.machinecoding.kafka.services.KafkaService;

public class ProducerService {

    private KafkaService kafkaService;

    public ProducerService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    public String publishMessage(String message, String topicName) {
        kafkaService.publish(message, topicName);
        return null;
    }
}
