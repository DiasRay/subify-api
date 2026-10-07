package com.subify.subify_api.infrastructure.adapter.output.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//a entidade especifica do JPA
@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class SubscriptionEntity {
    @Id
    private String id;
    private String customerId;
    private String status;
    private LocalDate nextBillingDate;

}
