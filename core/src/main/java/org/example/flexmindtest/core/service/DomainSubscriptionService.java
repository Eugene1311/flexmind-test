package org.example.flexmindtest.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.flexmindtest.common.interfaces.SubscriptionRepository;
import org.example.flexmindtest.common.interfaces.SubscriptionService;
import org.example.flexmindtest.common.model.EventConfig;
import org.example.flexmindtest.common.model.Subscription;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
@Slf4j
class DomainSubscriptionService implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final RestClient restClient = RestClient.create(); // todo make it global?

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.addSubscription(subscription);
    }

    @Override
    public void notifySubscribers(String eventType, EventConfig eventConfig) {
        subscriptionRepository.getAllByEventType(eventType).stream()
                .map(Subscription::callbackUrl)
                .forEach(url -> {
                    log.info("Sending request to subscriber by callbackUrl {}", url);
                    restClient.post()
                            .uri(url)
                            .contentType(APPLICATION_JSON)
                            .body(eventConfig);
                });
    }
}
