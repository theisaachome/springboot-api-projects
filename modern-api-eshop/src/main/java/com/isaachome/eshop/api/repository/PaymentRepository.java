package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
}
