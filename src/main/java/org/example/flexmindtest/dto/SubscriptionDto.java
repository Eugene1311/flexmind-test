package org.example.flexmindtest.dto;

public record SubscriptionDto(
        String eventType,
        String callbackUrl,
        boolean active
) {
}
