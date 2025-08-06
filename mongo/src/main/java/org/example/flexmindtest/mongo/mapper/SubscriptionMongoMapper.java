package org.example.flexmindtest.mongo.mapper;

import org.example.flexmindtest.common.model.Subscription;
import org.example.flexmindtest.mongo.entity.SubscriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMongoMapper {
    SubscriptionEntity toEntity(Subscription subscription);

    Subscription toModel(SubscriptionEntity entity);
}
