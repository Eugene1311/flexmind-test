package org.example.flexmindtest.mongo.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.common.interfaces.SubscriptionRepository;
import org.example.flexmindtest.common.model.Subscription;
import org.example.flexmindtest.mongo.entity.SubscriptionEntity;
import org.example.flexmindtest.mongo.mapper.SubscriptionMongoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MongoDBSubscriptionRepository implements SubscriptionRepository {
    private final SubscriptionMongoRepository subscriptionMongoRepository;
    private final SubscriptionMongoMapper subscriptionMapper;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        SubscriptionEntity saved = subscriptionMongoRepository.save(subscriptionMapper.toEntity(subscription));
        return subscriptionMapper.toModel(saved);
    }

    @Override
    public List<Subscription> getAllByEventType(String eventType) {
        return subscriptionMongoRepository.findAllByEventType(eventType).stream()
                .map(subscriptionMapper::toModel)
                .toList();
    }
}
