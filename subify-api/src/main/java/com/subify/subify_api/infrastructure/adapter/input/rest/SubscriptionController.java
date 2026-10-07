package com.subify.subify_api.infrastructure.adapter.input.rest;

import com.subify.subify_api.application.port.output.SubscriptionRepositoryPort;
import com.subify.subify_api.application.usecase.CancelSubscriptionUseCase;
import com.subify.subify_api.domain.entity.Subscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/subscriptions")
public class SubscriptionController {
    private final CancelSubscriptionUseCase cancelSubscriptionUseCase;
    private final SubscriptionRepositoryPort repositoryPort;

    public SubscriptionController(CancelSubscriptionUseCase cancelSubscriptionUseCase, SubscriptionRepositoryPort repositoryPort){
        this.cancelSubscriptionUseCase = cancelSubscriptionUseCase;
        this.repositoryPort = repositoryPort;
    }
    // Endpoint 1: Criar Assinatura para teste
    @PostMapping
    public ResponseEntity<Subscription> create(@RequestBody Map<String, String> body) {
        String id = body.get("id");
        String customerId = body.get("customerId");

        Subscription newSub = new Subscription(id, customerId);
        Subscription saved = repositoryPort.save(newSub);

        return ResponseEntity.ok(saved);
    }

    // Endpoint 2: Buscar Assinatura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Subscription> findById(@PathVariable String id) {
        return repositoryPort.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint 3: Cancelar Assinatura (O nosso UseCase!)
    @PatchMapping("{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable String id){
        cancelSubscriptionUseCase.execute(id);
        return ResponseEntity.noContent().build(); // Retorna HTTP 204
    }
}
