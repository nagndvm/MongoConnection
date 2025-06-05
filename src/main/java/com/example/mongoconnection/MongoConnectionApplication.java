package com.example.mongoconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.mongoconnection.repository")
@EnableMongoRepositories(basePackages = "com.example.mongoconnection.repository")
public class MongoConnectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoConnectionApplication.class, args);
    }

}
