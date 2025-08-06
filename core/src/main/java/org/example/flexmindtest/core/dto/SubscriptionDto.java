package org.example.flexmindtest.core.dto;

public record SubscriptionDto(
        String eventType,
        String callbackUrl,
        boolean active
) {
}
