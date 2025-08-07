package org.example.flexmindtest.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(name = "app.db", havingValue = "mongo")
@ComponentScan("org.example.flexmindtest.mongo")
@Import({
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class
})
public class MongoRepositoryConfiguration {
}
