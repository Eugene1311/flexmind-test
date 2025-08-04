package org.example.flexmindtest.mapper;

import org.example.flexmindtest.dto.SubscriptionDto;
import org.example.flexmindtest.model.Subscription;
import org.example.flexmindtest.repository.mongo.entity.SubscriptionMongoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMapper {
    SubscriptionMongoEntity toEntity(Subscription subscription);

    Subscription toModel(SubscriptionMongoEntity entity);

    Subscription toModel(SubscriptionDto subscriptionDto);
}
