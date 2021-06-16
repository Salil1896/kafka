package com.machinecoding.kafka.client;

import java.util.TimerTask;

public class PolingTask extends TimerTask {

    private String groupId;
    private SubscriberService subscriberService;
    private String topicName;

    public PolingTask(String groupId, String topicName, SubscriberService subscriberService) {
        this.groupId = groupId;
        this.topicName = topicName;
        this.subscriberService = subscriberService;
    }

    @Override
    public void run() {
        String message = subscriberService.pull(groupId, topicName);
        if (message != null) {
            System.out.println("Group Id: " + groupId + " Message: " + message);
        }
    }
}