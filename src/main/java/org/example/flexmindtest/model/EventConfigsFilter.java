package org.example.flexmindtest.model;

public record EventConfigsFilter(
        String eventType,
        String source,
        Boolean enabled
) {
}
