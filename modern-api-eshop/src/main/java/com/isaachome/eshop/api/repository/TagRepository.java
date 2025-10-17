package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<TagEntity, UUID> {
}
