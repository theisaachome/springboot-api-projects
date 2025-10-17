package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<CardEntity, UUID> {
}
