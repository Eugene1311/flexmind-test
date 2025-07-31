package org.example.flexmindtest.interfaces;

import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.model.EventConfigsFilter;

import java.util.List;

public interface EventConfigRepository {
    EventConfig addEventConfig(EventConfig config);
    EventConfig updateEventConfigById(String id, EventConfig config);
    List<EventConfig> getEventConfigs(EventConfigsFilter filter);
}
