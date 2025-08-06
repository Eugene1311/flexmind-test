package org.example.flexmindtest.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("subscription")
@Getter
@Setter
public class SubscriptionEntity {
    @Id
    String id;
    String eventType;
    String callbackUrl;
    boolean active;
}
