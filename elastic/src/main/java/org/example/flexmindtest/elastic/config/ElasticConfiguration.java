package org.example.flexmindtest.elastic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("org.example.flexmindtest.elastic")
public class ElasticConfiguration {
}
