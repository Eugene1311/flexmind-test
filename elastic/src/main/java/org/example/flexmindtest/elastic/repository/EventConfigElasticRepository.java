package org.example.flexmindtest.elastic.repository;

import org.example.flexmindtest.elastic.entity.EventConfigEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

interface EventConfigElasticRepository extends ElasticsearchRepository<EventConfigEntity, String> {}
