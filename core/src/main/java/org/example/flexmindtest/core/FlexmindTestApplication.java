package org.example.flexmindtest.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.elasticsearch.ElasticsearchRestHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class,
        ElasticsearchRestHealthContributorAutoConfiguration.class,
})
public class FlexmindTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlexmindTestApplication.class, args);
    }

}
