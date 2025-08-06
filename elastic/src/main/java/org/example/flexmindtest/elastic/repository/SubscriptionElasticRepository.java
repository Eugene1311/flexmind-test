package org.example.flexmindtest.elastic.repository;

import org.example.flexmindtest.elastic.entity.SubscriptionEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

interface SubscriptionElasticRepository extends ElasticsearchRepository<SubscriptionEntity, String> {
    List<SubscriptionEntity> findAllByEventType(String eventType);
}
