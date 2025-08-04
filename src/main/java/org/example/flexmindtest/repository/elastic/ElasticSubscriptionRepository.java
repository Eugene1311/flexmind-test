package org.example.flexmindtest.repository.elastic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.interfaces.SubscriptionRepository;
import org.example.flexmindtest.mapper.SubscriptionMapper;
import org.example.flexmindtest.model.Subscription;
import org.example.flexmindtest.repository.elastic.entity.SubscriptionElasticEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
class ElasticSubscriptionRepository implements SubscriptionRepository {
    private final SubscriptionElasticRepository subscriptionElasticRepository;
    private final SubscriptionMapper subscriptionMapper;
    @Override
    public Subscription addSubscription(Subscription subscription) {
        SubscriptionElasticEntity saved = subscriptionElasticRepository.save(subscriptionMapper.toElasticEntity(subscription));
        return subscriptionMapper.toModel(saved);
    }
}
