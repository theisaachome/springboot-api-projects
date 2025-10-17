package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipmentRepository extends JpaRepository<ShipmentEntity, UUID> {
}
