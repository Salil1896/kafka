package com.machinecoding.kafka.services;

import com.machinecoding.kafka.models.TopicMessage;
import com.machinecoding.kafka.models.Kafka;
import com.machinecoding.kafka.models.Topic;
import org.joda.time.DateTime;

public class TopicServiceImpl implements TopicService {

    @Override
    public boolean createTopic(Kafka kafka, String topicName, int partition) {
        Topic topic = new Topic(partition, topicName);
        return kafka.getKafkaMeta().addTopic(topic);
    }

    @Override
    public boolean push(Kafka kafka, String topicName, String message) {
        Topic topic = kafka.getKafkaMeta().getTopic(topicName);
        TopicMessage topicMessage = new TopicMessage(message, DateTime.now().plusMinutes(3));
        return topic.addMessage(topicMessage);
    }

    public boolean subscribe(Kafka kafka, String topicName, String groupId) {
        Topic topic = kafka.getKafkaMeta().getTopic(topicName);
        return topic.getTopicMeta().addSubscribers(groupId, topic.getMinOffset());
    }

    public String pull(Kafka kafka, String topicName, String groupId) {
        Topic topic = kafka.getKafkaMeta().getTopic(topicName);
        TopicMessage message = topic.getQueueMessage(groupId);
        if(message != null) return message.getMessage();
        return null;
    }
}
