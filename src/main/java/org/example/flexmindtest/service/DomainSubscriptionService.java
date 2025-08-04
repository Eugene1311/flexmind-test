package org.example.flexmindtest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.interfaces.SubscriptionRepository;
import org.example.flexmindtest.interfaces.SubscriptionService;
import org.example.flexmindtest.model.Subscription;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class DomainSubscriptionService implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.addSubscription(subscription);
    }
}
