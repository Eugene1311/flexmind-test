package org.example.flexmindtest.mapper;

import org.example.flexmindtest.dto.EventConfigDto;
import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.repository.elastic.entity.EventConfigElasticEntity;
import org.example.flexmindtest.repository.mongo.entity.EventConfigMongoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventConfigMapper {
    EventConfig toModel(EventConfigMongoEntity config);
    EventConfig toModel(EventConfigElasticEntity config);
    EventConfig toModel(EventConfigDto config);
    EventConfigMongoEntity toMongoEntity(EventConfig config);
    EventConfigElasticEntity toElasticEntity(EventConfig config);
}
