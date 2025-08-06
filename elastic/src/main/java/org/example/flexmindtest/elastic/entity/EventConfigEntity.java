package org.example.flexmindtest.elastic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Document(indexName = "eventconfig")
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
    @Field(type = FieldType.Date)
    private Instant createdAt;
    @Field(type = FieldType.Date)
    private Instant updatedAt;
}
