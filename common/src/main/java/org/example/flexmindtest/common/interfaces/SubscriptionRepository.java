package org.example.flexmindtest.common.interfaces;

import org.example.flexmindtest.common.model.Subscription;

import java.util.List;

public interface SubscriptionRepository {
    Subscription addSubscription(Subscription subscription);
    List<Subscription> getAllByEventType(String eventType);
}
