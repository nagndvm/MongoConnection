package com.example.mongoconnection.consumer;

import com.example.mongoconnection.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @KafkaListener(topics = "test-topic",groupId = "my-groupid")
    public void listen(User user) {
        System.out.println("Received Employee: " + user.getEmail() + " --- " + user.getName());
    }
}
