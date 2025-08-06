package org.example.flexmindtest.core.mapper;

import org.example.flexmindtest.core.dto.EventConfigDto;
import org.example.flexmindtest.common.model.EventConfig;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventConfigMapper {
    EventConfig toModel(EventConfigDto config);
}
