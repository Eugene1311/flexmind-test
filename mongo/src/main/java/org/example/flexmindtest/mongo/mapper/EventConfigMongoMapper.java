package org.example.flexmindtest.mongo.mapper;

import org.example.flexmindtest.common.model.EventConfig;
import org.example.flexmindtest.mongo.entity.EventConfigEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventConfigMongoMapper {
    EventConfig toModel(EventConfigEntity config);
    EventConfigEntity toEntity(EventConfig config);
}
