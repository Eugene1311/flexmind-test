package org.example.flexmindtest.repository.elastic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "subscription")
@Getter
@Setter
public class SubscriptionElasticEntity {
    @Id
    String id;
    String eventType;
    String callbackUrl;
    boolean active;
}
