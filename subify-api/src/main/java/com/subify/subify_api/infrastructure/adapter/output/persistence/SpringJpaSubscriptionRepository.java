package com.subify.subify_api.infrastructure.adapter.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

//A interface Spring Data JPA
public interface SpringJpaSubscriptionRepository extends JpaRepository<SubscriptionEntity, String> {

}
