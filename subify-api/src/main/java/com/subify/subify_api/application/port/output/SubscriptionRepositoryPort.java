package com.subify.subify_api.application.port.output;

import com.subify.subify_api.domain.entity.Subscription;

import java.util.Optional;

//A interface que diz o que o sistema precisa salvar no banco, sem saber qual banco é.

public interface SubscriptionRepositoryPort {
    Subscription save(Subscription subscription);
    Optional<Subscription> findById(String id);
}
