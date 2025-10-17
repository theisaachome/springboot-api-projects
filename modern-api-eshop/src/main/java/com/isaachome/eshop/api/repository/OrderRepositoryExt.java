package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.OrderEntity;
import com.isaachome.eshop.api.model.NewOrder;

import java.util.Optional;

public interface OrderRepositoryExt {
    Optional<OrderEntity> insert(NewOrder m);
}
