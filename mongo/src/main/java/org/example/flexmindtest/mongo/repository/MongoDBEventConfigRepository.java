package org.example.flexmindtest.mongo.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.common.exception.NotFoundException;
import org.example.flexmindtest.common.interfaces.EventConfigRepository;
import org.example.flexmindtest.common.model.EventConfig;
import org.example.flexmindtest.common.model.EventConfigsFilter;
import org.example.flexmindtest.mongo.entity.EventConfigEntity;
import org.example.flexmindtest.mongo.mapper.EventConfigMongoMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MongoDBEventConfigRepository implements EventConfigRepository {
    private final MongoTemplate mongoTemplate;
    private final EventConfigMongoMapper eventConfigMapper;
    private final EventConfigMongoRepository eventConfigMongoRepository;

    @Override
    public EventConfig addEventConfig(EventConfig config) {
        EventConfigEntity entity = eventConfigMapper.toEntity(config);
        EventConfigEntity entityToSave = entity.withCreatedAt(Instant.now());
        EventConfigEntity saved = eventConfigMongoRepository.save(entityToSave);
        return eventConfigMapper.toModel(saved);
    }

    @Override
    public EventConfig updateEventConfigById(String id, EventConfig config) {
        return eventConfigMongoRepository.findById(id)
                .map(configEntity -> {
                    String eventType = Optional.ofNullable(config.eventType())
                            .orElse(configEntity.getEventType());
                    String source = Optional.ofNullable(config.source())
                            .orElse(configEntity.getSource());
                    boolean enabled = Optional.ofNullable(config.enabled())
                            .orElse(configEntity.isEnabled());
                    EventConfigEntity updatedEntity = configEntity
                            .withEventType(eventType)
                            .withSource(source)
                            .withEnabled(enabled)
                            .withUpdatedAt(Instant.now());
                    EventConfigEntity saved = eventConfigMongoRepository.save(updatedEntity);
                    return eventConfigMapper.toModel(saved);
                })
                .orElseThrow(() -> new NotFoundException(String.format("Event config with id %s is not found", id)));
    }

    @Override
    public List<EventConfig> getEventConfigs(EventConfigsFilter filter) {
        // todo try https://medium.com/whozapp/optional-parameters-in-spring-mongo-repositories-c90ba56e6e87 ?
        Query query = new Query();
        if (filter.eventType() != null) {
            query.addCriteria(Criteria.where("eventType").is(filter.eventType()));
        }
        if (filter.source() != null) {
            query.addCriteria(Criteria.where("source").is(filter.source()));
        }
        if (filter.enabled() != null) {
            query.addCriteria(Criteria.where("enabled").is(filter.enabled()));
        }

        return mongoTemplate.find(query, EventConfigEntity.class).stream()
                .map(eventConfigMapper::toModel)
                .toList();
    }
}
