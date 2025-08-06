package org.example.flexmindtest.common.interfaces;

import org.example.flexmindtest.common.model.EventConfig;
import org.example.flexmindtest.common.model.EventConfigsFilter;

import java.util.List;

public interface EventConfigRepository {
    EventConfig addEventConfig(EventConfig config);
    EventConfig updateEventConfigById(String id, EventConfig config);
    List<EventConfig> getEventConfigs(EventConfigsFilter filter);
}
