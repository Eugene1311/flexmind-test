package org.example.flexmindtest.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "app.db", havingValue = "mongo")
@ComponentScan("org.example.flexmindtest.mongo")
public class MongoRepositoryConfiguration {
}
