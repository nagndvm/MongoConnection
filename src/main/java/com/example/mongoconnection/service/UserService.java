package com.example.mongoconnection.service;

import com.example.mongoconnection.model.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;;

    public void sendMessage(User User) {
        kafkaTemplate.send("test-topic", User);
        System.out.println("Message sent to topic");
    }

    @KafkaListener(topics = "test-topic")
    public void listen(User user) {
        System.out.println("Received Employee: " + user);
    }


}
