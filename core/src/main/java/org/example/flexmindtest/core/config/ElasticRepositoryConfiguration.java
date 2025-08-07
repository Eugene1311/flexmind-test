package org.example.flexmindtest.core.config;

import org.springframework.boot.actuate.autoconfigure.elasticsearch.ElasticsearchRestHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(name = "app.db", havingValue = "elastic")
@ComponentScan(value = "org.example.flexmindtest.elastic")
@Import({
        ElasticsearchRestHealthContributorAutoConfiguration.class,
})
public class ElasticRepositoryConfiguration {
}
