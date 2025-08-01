package org.example.flexmindtest.repository.mongo;

import org.example.flexmindtest.repository.mongo.entity.EventConfigMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

interface EventConfigMongoRepository extends MongoRepository<EventConfigMongoEntity, String> {
}
