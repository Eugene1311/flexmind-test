package org.example.flexmindtest.repository.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.interfaces.SubscriptionRepository;
import org.example.flexmindtest.mapper.SubscriptionMapper;
import org.example.flexmindtest.model.Subscription;
import org.example.flexmindtest.repository.mongo.entity.SubscriptionMongoEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(name = "app.db", havingValue = "mongodb")
@RequiredArgsConstructor
@Slf4j
class MongoDBSubscriptionRepository implements SubscriptionRepository {
    private final SubscriptionMongoRepository subscriptionMongoRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        SubscriptionMongoEntity saved = subscriptionMongoRepository.save(subscriptionMapper.toEntity(subscription));
        return subscriptionMapper.toModel(saved);
    }
}
