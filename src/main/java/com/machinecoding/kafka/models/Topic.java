package com.machinecoding.kafka.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Topic {

    private int partition;
    private String name;
    private Map<Long, TopicMessage> offsetVsMessage;
    private TopicMeta topicMeta;
    private long currentOffset;
    private long minOffset;

    public Topic(int partition, String name) {
        this.partition = partition;
        this.name = name;
        this.offsetVsMessage = new LinkedHashMap<>();
        this.topicMeta = new TopicMeta();
        this.currentOffset = 0;
        this.minOffset = 0;
    }

    public String getName() {
        return name;
    }

    public boolean addMessage(TopicMessage topicMessage) {
        topicMessage.setOffset(currentOffset);
        offsetVsMessage.put(currentOffset, topicMessage);
        currentOffset++;
        return true;
    }

    public TopicMeta getTopicMeta() {
        return topicMeta;
    }

    public TopicMessage getQueueMessage(String groupId) {
        Long offset = this.topicMeta.getSubsOffset(groupId);
        if (offset < currentOffset) {
            TopicMessage message = offsetVsMessage.get(offset);
            topicMeta.incrementOffset(groupId);
            return message;
        }

        return null;
    }

    public long getMinOffset() {
        return minOffset;
    }

    public long getCurrentOffset() {
        return currentOffset;
    }
}

