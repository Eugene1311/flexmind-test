package org.example.flexmindtest.repository.elastic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.interfaces.SubscriptionRepository;
import org.example.flexmindtest.mapper.SubscriptionMapper;
import org.example.flexmindtest.model.Subscription;
import org.example.flexmindtest.repository.elastic.entity.SubscriptionElasticEntity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ConditionalOnProperty(name = "app.db", havingValue = "elastic")
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

    @Override
    public List<Subscription> getAllByEventType(String eventType) {
        return subscriptionElasticRepository.findAllByEventType(eventType).stream()
                .map(subscriptionMapper::toModel)
                .toList();
    }
}
