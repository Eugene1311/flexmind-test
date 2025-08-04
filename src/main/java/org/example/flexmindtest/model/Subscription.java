package org.example.flexmindtest.model;

public record Subscription(
   String id,
   String eventType,
   String callbackUrl,
   boolean active
) {
}
