package org.example.flexmindtest.repository.elastic;

import lombok.RequiredArgsConstructor;
import org.example.flexmindtest.exception.NotFoundException;
import org.example.flexmindtest.interfaces.EventConfigRepository;
import org.example.flexmindtest.mapper.EventConfigMapper;
import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.model.EventConfigsFilter;
import org.example.flexmindtest.repository.elastic.entity.EventConfigElasticEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
@ConditionalOnProperty(name = "app.db", havingValue = "elastic") // todo move to config?
@RequiredArgsConstructor
class ElasticEventConfigRepository implements EventConfigRepository {
    private final EventConfigElasticRepository eventConfigElasticRepository;
    private final ElasticsearchTemplate elasticsearchTemplate;
    private final EventConfigMapper eventConfigMapper;

    @Override
    public EventConfig addEventConfig(EventConfig config) {
        EventConfigElasticEntity entity = eventConfigMapper.toElasticEntity(config);
        EventConfigElasticEntity saved = eventConfigElasticRepository.save(entity.withCreatedAt(Instant.now()));
        return eventConfigMapper.toModel(saved);
    }

    @Override
    public EventConfig updateEventConfigById(String id, EventConfig config) {
        return eventConfigElasticRepository.findById(id)
                .map(configEntity -> {
                    String eventType = Optional.ofNullable(config.eventType())
                            .orElse(configEntity.getEventType());
                    String source = Optional.ofNullable(config.source())
                            .orElse(configEntity.getSource());
                    boolean enabled = Optional.ofNullable(config.enabled())
                            .orElse(configEntity.isEnabled());
                    EventConfigElasticEntity updatedEntity = configEntity
                            .withEventType(eventType)
                            .withSource(source)
                            .withEnabled(enabled)
                            .withUpdatedAt(Instant.now());
                    EventConfigElasticEntity saved = eventConfigElasticRepository.save(updatedEntity);
                    return eventConfigMapper.toModel(saved);
                })
                .orElseThrow(() -> new NotFoundException(String.format("Event config with id %s is not found", id)));
    }

    @Override
    public List<EventConfig> getEventConfigs(EventConfigsFilter filter) {
        // todo use Search Templates (Elasticsearch feature)?
        Criteria criteria = new Criteria();

        if (filter.eventType() != null) {
            criteria = criteria.and("eventType").is(filter.eventType());
        }
        if (filter.source() != null) {
            criteria = criteria.and("source").is(filter.source());
        }
        if (filter.enabled() != null) {
            criteria = criteria.and("enabled").is(filter.enabled());
        }

        CriteriaQuery query = new CriteriaQuery(criteria);

        return elasticsearchTemplate.search(query, EventConfigElasticEntity.class).stream()
                .map(SearchHit::getContent)
                .map(eventConfigMapper::toModel)
                .toList();
    }
}
