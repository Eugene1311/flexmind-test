package org.example.flexmindtest.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("org.example.flexmindtest.mongo")
public class MongoConfiguration {
}
