package org.example.flexmindtest.interfaces;

import org.example.flexmindtest.model.EventConfig;
import org.example.flexmindtest.model.Subscription;

public interface SubscriptionService {
    Subscription addSubscription(Subscription subscription);
    void notifySubscribers(String eventType, EventConfig eventConfig);
}
