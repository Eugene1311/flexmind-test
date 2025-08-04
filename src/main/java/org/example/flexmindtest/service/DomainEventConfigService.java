package org.example.flexmindtest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.interfaces.EventConfigService;
import org.example.flexmindtest.interfaces.SubscriptionService;
import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.model.EventConfigsFilter;
import org.example.flexmindtest.interfaces.EventConfigRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
class DomainEventConfigService implements EventConfigService {
    private final EventConfigRepository eventConfigRepository;
    private final SubscriptionService subscriptionService;

    @Override
    public EventConfig addEventConfig(EventConfig config) {
        return eventConfigRepository.addEventConfig(config);
    }

    @Override
    public EventConfig updateEventConfigById(String id, EventConfig config) {
        EventConfig updatedConfig = eventConfigRepository.updateEventConfigById(id, config);
        subscriptionService.notifySubscribers(updatedConfig.eventType(), config);
        return updatedConfig;
    }

    @Override
    public List<EventConfig> getEventConfigs(EventConfigsFilter filter) {
        return eventConfigRepository.getEventConfigs(filter);
    }

    @Override
    public Map<String, List<EventConfig>> getEventConfigsGroupedBySource() {
        return eventConfigRepository.getEventConfigs(new EventConfigsFilter(null, null, null)).stream()
                .filter(config -> Objects.nonNull(config.source()))
                .collect(Collectors.groupingBy(EventConfig::source));
    }
}
