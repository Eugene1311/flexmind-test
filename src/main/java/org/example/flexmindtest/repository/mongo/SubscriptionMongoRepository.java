package org.example.flexmindtest.repository.mongo;

import org.example.flexmindtest.repository.mongo.entity.SubscriptionMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

interface SubscriptionMongoRepository extends MongoRepository<SubscriptionMongoEntity, String> {
}
