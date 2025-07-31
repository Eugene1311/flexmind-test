package org.example.flexmindtest.repository.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.exception.NotFoundException;
import org.example.flexmindtest.interfaces.EventConfigRepository;
import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.model.EventConfigsFilter;
import org.example.flexmindtest.repository.mongo.entity.EventConfigEntity;
import org.example.flexmindtest.mapper.EventConfigMapper;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MongoDBEventConfigRepository implements EventConfigRepository {
    private final EventConfigMongoRepository eventConfigMongoRepository;
    private final EventConfigMapper eventConfigMapper;

    @Override
    public EventConfig addEventConfig(EventConfig config) {
        EventConfigEntity entity = eventConfigMapper.toEntity(config);
        EventConfigEntity entityToSave = entity.withCreatedAt(Instant.now());
        EventConfigEntity saved = eventConfigMongoRepository.save(entityToSave);
        return eventConfigMapper.toModel(saved);
    }

    @Override
    public EventConfig updateEventConfigById(String id, EventConfig config) {
        // todo
        return eventConfigMongoRepository.findById(id)
                .map(configEntity -> {
                    EventConfig configToUpdate = config.withId(id);
                    EventConfigEntity entity = eventConfigMapper.toEntity(configToUpdate);
                    EventConfigEntity updatedEntity = entity
                            .withUpdatedAt(Instant.now());
                    EventConfigEntity saved = eventConfigMongoRepository.save(updatedEntity);
                    return eventConfigMapper.toModel(saved);
                })
                .orElseThrow(() -> new NotFoundException(String.format("Event config with id %s is not found", id)));
    }

    @Override
    public List<EventConfig> getEventConfigs(EventConfigsFilter filter) {
        return null;
    }
}
