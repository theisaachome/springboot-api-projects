package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, UUID> {
}
