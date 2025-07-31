package org.example.flexmindtest.model;

import lombok.With;

import java.time.Instant;

@With
public record EventConfig(
      String id,
      String eventType,
      String source,
      Boolean enabled,
      Instant createdAt,
      Instant updatedAt
) {
}
