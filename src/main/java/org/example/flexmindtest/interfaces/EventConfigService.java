package org.example.flexmindtest.interfaces;

import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.model.EventConfigsFilter;

import java.util.List;
import java.util.Map;

public interface EventConfigService {
    /* создание конфигурации */
    EventConfig addEventConfig(EventConfig config);
    /* обновление конфигурации */
    EventConfig updateEventConfigById(String id, EventConfig config);
    /* получение списка конфигураций с фильтрацией по полям eventType, source, enabled */
    List<EventConfig> getEventConfigs(EventConfigsFilter filter);
    Map<String, List<EventConfig>> getEventConfigsGroupedBySource();
}
