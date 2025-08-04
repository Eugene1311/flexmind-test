package org.example.flexmindtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.flexmindtest.dto.SubscriptionDto;
import org.example.flexmindtest.interfaces.SubscriptionService;
import org.example.flexmindtest.mapper.SubscriptionMapper;
import org.example.flexmindtest.model.Subscription;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;

    @PostMapping
    public Subscription addSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.addSubscription(subscriptionMapper.toModel(subscriptionDto));
    }
}
