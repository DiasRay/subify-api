package com.subify.subify_api.infrastructure.adapter.output.persistence;

import com.subify.subify_api.application.port.output.SubscriptionRepositoryPort;
import com.subify.subify_api.domain.entity.Subscription;
import org.springframework.stereotype.Component;

import java.util.Optional;

//Adaptador Concreto que implementa a Porta da Aplicação
@Component
public class SubscriptionRepositoryAdapter implements SubscriptionRepositoryPort {
    private final SpringJpaSubscriptionRepository springRepository;

    public SubscriptionRepositoryAdapter (SpringJpaSubscriptionRepository springRepository){
        this.springRepository = springRepository;
    }

    @Override
    public Subscription save(Subscription domain) {
        SubscriptionEntity entity = new SubscriptionEntity();
        entity.setId(domain.getId()); // O ID deve ser idêntico ao já existente para o JPA fazer UPDATE em vez de INSERT
        entity.setCustomerId(domain.getCustomerId());
        entity.setStatus(domain.getStatus());
        entity.setNextBillingDate(domain.getNextBillingDate());

        SubscriptionEntity saved = springRepository.save(entity);

        return new Subscription(
                saved.getId(),
                saved.getCustomerId(),
                saved.getStatus(),
                saved.getNextBillingDate()
        );
    }

    @Override
    public Optional<Subscription> findById(String id) {
        return springRepository.findById(id)
                .map(e -> new Subscription(
                        e.getId(),
                        e.getCustomerId(),
                        e.getStatus(), // 👈 Agora ele lê o status REAL do banco ("CANCELLED")
                        e.getNextBillingDate()
                ));
    }
}
