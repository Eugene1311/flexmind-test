package org.example.flexmindtest.repository.mongo;

import org.example.flexmindtest.repository.mongo.entity.EventConfigEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventConfigMongoRepository extends MongoRepository<EventConfigEntity, String> {
}
