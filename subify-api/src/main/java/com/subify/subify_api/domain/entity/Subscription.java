package com.subify.subify_api.domain.entity;

import com.subify.subify_api.domain.exception.SubscriptionException;
import java.time.LocalDate;

public class Subscription {
    private String id;
    private String customerId;
    private String status;
    private LocalDate nextBillingDate;

    // Construtor 1: Para criar novas assinaturas (com status inicial ACTIVE)
    public Subscription(String id, String customerId) {
        this.id = id;
        this.customerId = customerId;
        this.status = "ACTIVE";
        this.nextBillingDate = LocalDate.now().plusDays(30);
    }

    // Construtor 2: ADICIONE ESTE CONSTRUTOR AQUI!
    // Ele é usado pelo Adaptador para reconstituir a entidade com os dados vindos do banco
    public Subscription(String id, String customerId, String status, LocalDate nextBillingDate) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.nextBillingDate = nextBillingDate;
    }

    // Regra de Negócio
    public void cancel() {
        if ("CANCELLED".equals(this.status)) {
            throw new SubscriptionException("Esta assinatura já está cancelada.");
        }
        this.status = "CANCELLED";
    }

    // Getters
    public String getId() { return id; }
    public String getCustomerId() { return customerId; }
    public String getStatus() { return status; }
    public LocalDate getNextBillingDate() { return nextBillingDate; }
}