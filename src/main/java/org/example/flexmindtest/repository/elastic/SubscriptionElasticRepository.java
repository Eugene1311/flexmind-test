package org.example.flexmindtest.repository.elastic;

import org.example.flexmindtest.repository.elastic.entity.SubscriptionElasticEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

interface SubscriptionElasticRepository extends ElasticsearchRepository<SubscriptionElasticEntity, String> {
}
