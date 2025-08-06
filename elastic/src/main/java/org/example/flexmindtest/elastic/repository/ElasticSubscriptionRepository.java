package org.example.flexmindtest.elastic.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.common.interfaces.SubscriptionRepository;
import org.example.flexmindtest.elastic.mapper.SubscriptionElasticMapper;
import org.example.flexmindtest.common.model.Subscription;
import org.example.flexmindtest.elastic.entity.SubscriptionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
class ElasticSubscriptionRepository implements SubscriptionRepository {
    private final SubscriptionElasticRepository subscriptionElasticRepository;
    private final SubscriptionElasticMapper subscriptionMapper;
    @Override
    public Subscription addSubscription(Subscription subscription) {
        SubscriptionEntity saved = subscriptionElasticRepository.save(subscriptionMapper.toElasticEntity(subscription));
        return subscriptionMapper.toModel(saved);
    }

    @Override
    public List<Subscription> getAllByEventType(String eventType) {
        return subscriptionElasticRepository.findAllByEventType(eventType).stream()
                .map(subscriptionMapper::toModel)
                .toList();
    }
}
