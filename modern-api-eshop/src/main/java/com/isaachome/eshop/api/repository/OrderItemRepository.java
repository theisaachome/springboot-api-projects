package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, UUID> {
}
