package com.machinecoding.kafka.models;

import java.util.HashMap;
import java.util.Map;

public class KafkaMeta {

    private Map<String, Topic> topicMap;

    public KafkaMeta() {
        this.topicMap = new HashMap<>();
    }

    public boolean addTopic(Topic topic) {
        topicMap.put(topic.getName(), topic);
        return true;
    }

    public Topic getTopic(String topicName) {
        return topicMap.get(topicName);
    }
}

