package org.example.flexmindtest.elastic.mapper;

import org.example.flexmindtest.common.model.Subscription;
import org.example.flexmindtest.elastic.entity.SubscriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionElasticMapper {
    SubscriptionEntity toElasticEntity(Subscription subscription);

    Subscription toModel(SubscriptionEntity saved);
}
