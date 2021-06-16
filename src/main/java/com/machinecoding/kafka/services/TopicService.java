package com.machinecoding.kafka.services;


import com.machinecoding.kafka.models.Kafka;

public interface TopicService {

    boolean createTopic(Kafka kafka, String topicName, int partition);

    boolean push(Kafka kafka, String topicName, String message);

    boolean subscribe(Kafka kafka, String topicName, String groupId);

    String pull(Kafka kafka, String topicName, String groupId);

}
