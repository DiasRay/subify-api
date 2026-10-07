package com.subify.subify_api.application.usecase;

import com.subify.subify_api.application.port.output.SubscriptionRepositoryPort;
import com.subify.subify_api.domain.entity.Subscription;

//É a classe que executa a ação.
public class CancelSubscriptionUseCase {
    private final SubscriptionRepositoryPort repositoryPort;

    public CancelSubscriptionUseCase(SubscriptionRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public void execute(String subscriptionId){
        Subscription subscription = repositoryPort.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Assinatura não encontrada."));

        //Chama a regra do domínio
        subscription.cancel();

        //Salva o estado alterado no banco via porta de Saída
        repositoryPort.save(subscription);
    }
}

