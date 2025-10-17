package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
