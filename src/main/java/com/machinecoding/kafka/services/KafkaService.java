package com.machinecoding.kafka.services;


public interface KafkaService {

    Boolean register(String topicName, String subscriber);

    Boolean createTopic(String topicName, int partition);

    void publish(String message, String topicName);

    String pull(String topicName, String groupId);

}
