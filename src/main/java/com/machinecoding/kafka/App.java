package com.machinecoding.kafka;

import com.machinecoding.kafka.services.KafkaFactory;
import com.machinecoding.kafka.services.KafkaService;
import com.machinecoding.kafka.services.KafkaServiceImpl;
import com.machinecoding.kafka.client.PolingTask;
import com.machinecoding.kafka.client.ProducerService;
import com.machinecoding.kafka.client.SubscriberService;

import java.util.Scanner;
import java.util.Timer;

public class App {

    public static void main(String args[]) {

        KafkaFactory kafkaFactory = new KafkaFactory();

        String topicName = "topic-1";
        KafkaService kafkaService = new KafkaServiceImpl(kafkaFactory.getKafka("Kafka-Queue"));
        kafkaService.createTopic(topicName, 10);

        ProducerService producerService = new ProducerService(kafkaService);
        SubscriberService subscriberService = new SubscriberService(kafkaService);

        kafkaService.register(topicName, "sub_101");
        kafkaService.register(topicName, "sub_102");

        Timer timer = new Timer();
        PolingTask task1 = new PolingTask("sub_101", topicName, subscriberService);
        timer.schedule(task1, 100l, 100l);


        PolingTask task2 = new PolingTask("sub_102", topicName, subscriberService);
        timer.schedule(task2, 5000l, 5000l);


        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();
            producerService.publishMessage(s, topicName);
        }

    }

}
