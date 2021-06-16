package com.machinecoding.kafka.services;

import com.machinecoding.kafka.models.Kafka;

public class KafkaServiceImpl implements KafkaService {

    private Kafka kafka;
    private TopicService topicService;

    public KafkaServiceImpl(Kafka kafka) {
        this.kafka = kafka;
        this.topicService = new TopicServiceImpl();
    }

    public Boolean register(String topicName, String subscriber) {
        if (subscriber == null) return false;
        return topicService.subscribe(this.kafka, topicName, subscriber);
    }

    public void publish(String message, String topicName) {
        topicService.push(kafka, topicName, message);
    }

    public String pull(String topicName, String groupId) {
        return topicService.pull(kafka, topicName, groupId);
    }

    public Boolean createTopic(String topicName, int partition) {
        return topicService.createTopic(kafka, topicName, partition);
    }
}
