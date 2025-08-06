package org.example.flexmindtest.mongo.repository;

import org.example.flexmindtest.mongo.entity.EventConfigEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventConfigMongoRepository extends MongoRepository<EventConfigEntity, String> {
}
