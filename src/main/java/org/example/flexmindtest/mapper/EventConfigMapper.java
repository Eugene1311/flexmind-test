package org.example.flexmindtest.mapper;

import org.example.flexmindtest.dto.EventConfigDto;
import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.repository.mongo.entity.EventConfigEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventConfigMapper {
    EventConfig toModel(EventConfigEntity config);
    EventConfig toModel(EventConfigDto config);
    EventConfigEntity toEntity(EventConfig config);
}
