package com.subify.subify_api.infrastructure.config;

import com.subify.subify_api.application.port.output.SubscriptionRepositoryPort;
import com.subify.subify_api.application.usecase.CancelSubscriptionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CancelSubscriptionUseCase cancelSubscriptionUseCase(SubscriptionRepositoryPort repositoryPort){
        return new CancelSubscriptionUseCase(repositoryPort);
    }
}
