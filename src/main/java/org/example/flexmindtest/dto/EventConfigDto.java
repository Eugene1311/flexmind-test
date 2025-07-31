package org.example.flexmindtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EventConfigDto(
        String eventType,
        String source,
        Boolean enabled
) {
}
