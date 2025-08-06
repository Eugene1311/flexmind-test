package org.example.flexmindtest.common.model;

public record EventConfigsFilter(
        String eventType,
        String source,
        Boolean enabled
) {
}
