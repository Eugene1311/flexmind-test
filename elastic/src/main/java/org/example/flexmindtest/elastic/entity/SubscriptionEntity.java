package org.example.flexmindtest.elastic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "subscription")
@Getter
@Setter
public class SubscriptionEntity {
    @Id
    String id;
    String eventType;
    String callbackUrl;
    boolean active;
}
