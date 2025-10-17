package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    @Query("SELECT o FROM OrderEntity o JOIN o.userEntity u WHERE u.id = :customerId")
    Iterable<OrderEntity> findAllByCustomerId(@Param("customerId") UUID customerId);
}
