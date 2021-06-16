package com.machinecoding.kafka.services;

import com.machinecoding.kafka.models.Kafka;

/**
 * @author salil.mamodiya
 * 16/06/21
 */
public class KafkaFactory {

    public Kafka getKafka(String queueName) {
        return new Kafka(queueName);
    }

}
