package org.example.flexmindtest.mongo.repository;

import org.example.flexmindtest.mongo.entity.SubscriptionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubscriptionMongoRepository extends MongoRepository<SubscriptionEntity, String> {
    List<SubscriptionEntity> findAllByEventType(String eventType);
}
