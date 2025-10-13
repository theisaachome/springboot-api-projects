package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends CrudRepository<CartEntity, UUID> {

     @Query("""
            SELECT C FROM CartEntity c join c.user u where u.id = :customerId
        """)
     Optional<CartEntity> findByCustomerId(@Param("customerId") UUID customerId);
}
