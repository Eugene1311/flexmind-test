package org.example.flexmindtest.core.controller;

import lombok.RequiredArgsConstructor;
import org.example.flexmindtest.core.dto.SubscriptionDto;
import org.example.flexmindtest.core.mapper.SubscriptionMapper;
import org.example.flexmindtest.common.interfaces.SubscriptionService;
import org.example.flexmindtest.common.model.Subscription;
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
