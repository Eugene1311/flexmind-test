package org.example.flexmindtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.flexmindtest.interfaces.EventConfigService;
import org.example.flexmindtest.model.EventConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ui")
@RequiredArgsConstructor
public class UIController {
    private final EventConfigService eventConfigService;

    @GetMapping("event-configs")
    public Map<String, List<EventConfig>> getEventConfigsGroupedBySource() {
        return eventConfigService.getEventConfigsGroupedBySource();
    }
}
