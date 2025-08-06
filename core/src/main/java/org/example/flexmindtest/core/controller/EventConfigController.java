package org.example.flexmindtest.core.controller;

import lombok.RequiredArgsConstructor;
import org.example.flexmindtest.core.dto.EventConfigDto;
import org.example.flexmindtest.core.mapper.EventConfigMapper;
import org.example.flexmindtest.common.interfaces.EventConfigService;
import org.example.flexmindtest.common.model.EventConfig;
import org.example.flexmindtest.common.model.EventConfigsFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event-config")
@RequiredArgsConstructor
public class EventConfigController {
    private final EventConfigService eventConfigService;
    private final EventConfigMapper eventConfigMapper;

    @PostMapping
    public EventConfig addEventConfig(@RequestBody EventConfigDto config) {
        return eventConfigService.addEventConfig(eventConfigMapper.toModel(config));
    }

    @PutMapping("{id}")
    public EventConfig updateEventConfigById(@PathVariable String id, @RequestBody EventConfigDto config) {
        return eventConfigService.updateEventConfigById(id, eventConfigMapper.toModel(config));
    }

    @GetMapping
    public List<EventConfig> getEventConfigs(
            @RequestParam(required = false) String eventType,
            @RequestParam(required = false) String source,
            @RequestParam(required = false) Boolean enabled) {
        EventConfigsFilter filter = new EventConfigsFilter(eventType, source, enabled);
        return eventConfigService.getEventConfigs(filter);
    }
}
