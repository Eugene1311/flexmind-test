package org.example.flexmindtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.flexmindtest.dto.EventConfigDto;
import org.example.flexmindtest.interfaces.EventConfigService;
import org.example.flexmindtest.mapper.EventConfigMapper;
import org.example.flexmindtest.model.EventConfig;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
