package org.example.flexmindtest.common.model;

// todo it's really strange that Subscription doesn't link to EventConfig
public record Subscription(
   String id,
   String eventType,
   String callbackUrl,
   boolean active
) {
}
