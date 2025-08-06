package org.example.flexmindtest.core.mapper;

import org.example.flexmindtest.common.model.Subscription;
import org.example.flexmindtest.core.dto.SubscriptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMapper {
    Subscription toModel(SubscriptionDto subscriptionDto);
}
