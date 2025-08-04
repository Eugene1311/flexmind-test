package org.example.flexmindtest.interfaces;

import org.example.flexmindtest.model.Subscription;

import java.util.List;

public interface SubscriptionRepository {
    Subscription addSubscription(Subscription subscription);
    List<Subscription> getAllByEventType(String eventType);
}
