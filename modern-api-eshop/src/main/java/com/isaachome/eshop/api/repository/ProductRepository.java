package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
