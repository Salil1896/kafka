package com.machinecoding.kafka.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicMeta {

    private Map<String, Long> subVsOffset;
    private List<String> subscribers;

    public TopicMeta() {
        this.subVsOffset = new HashMap<>();
        subscribers = new ArrayList<>();
    }

    public boolean addSubscribers(String groupId, long offSet) {
        subscribers.add(groupId);
        subVsOffset.put(groupId, offSet);
        return true;
    }

    public Long getSubsOffset(String subscriber) {
        return subVsOffset.get(subscriber);
    }

    public boolean incrementOffset(String subscriber) {
        subVsOffset.put(subscriber, subVsOffset.get(subscriber) + 1);
        return true;
    }
}

