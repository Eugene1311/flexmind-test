package org.example.flexmindtest.common.interfaces;

import org.example.flexmindtest.common.model.EventConfig;
import org.example.flexmindtest.common.model.Subscription;

public interface SubscriptionService {
    Subscription addSubscription(Subscription subscription);
    void notifySubscribers(String eventType, EventConfig eventConfig);
}
