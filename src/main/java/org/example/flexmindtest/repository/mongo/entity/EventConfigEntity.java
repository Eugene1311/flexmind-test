package org.example.flexmindtest.repository.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("eventConfig")
@Getter
@Setter
@AllArgsConstructor
@With
public class EventConfigEntity {
    @Id
    String id;
    String eventType;
    String source;
    boolean enabled;
    Instant createdAt;
    Instant updatedAt;
}
