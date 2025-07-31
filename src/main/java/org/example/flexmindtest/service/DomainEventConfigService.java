package org.example.flexmindtest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.interfaces.EventConfigService;
import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.model.EventConfigsFilter;
import org.example.flexmindtest.interfaces.EventConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DomainEventConfigService implements EventConfigService {
    private final EventConfigRepository eventConfigRepository;

    @Override
    public EventConfig addEventConfig(EventConfig config) {
        return eventConfigRepository.addEventConfig(config);
    }

    @Override
    public EventConfig updateEventConfigById(String id, EventConfig config) {
        return eventConfigRepository.updateEventConfigById(id, config);
    }

    @Override
    public List<EventConfig> getEventConfigs(EventConfigsFilter filter) {
        return eventConfigRepository.getEventConfigs(filter);
    }
}
