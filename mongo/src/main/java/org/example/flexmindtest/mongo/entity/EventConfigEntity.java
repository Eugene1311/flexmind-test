package org.example.flexmindtest.mongo.entity;

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
    private String id;
    private String eventType;
    private String source;
    private boolean enabled;
    private Instant createdAt;
    private Instant updatedAt;
}
