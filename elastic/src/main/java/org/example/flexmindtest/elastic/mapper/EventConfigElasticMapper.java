package org.example.flexmindtest.elastic.mapper;

import org.example.flexmindtest.common.model.EventConfig;
import org.example.flexmindtest.elastic.entity.EventConfigEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventConfigElasticMapper {
    EventConfig toModel(EventConfigEntity config);
    EventConfigEntity toEntity(EventConfig config);
}
