package org.example.flexmindtest.repository.elastic;

import org.example.flexmindtest.repository.elastic.entity.EventConfigElasticEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
interface EventConfigElasticRepository extends ElasticsearchRepository<EventConfigElasticEntity, String> {}
