package com.isaachome.eshop.api.repository;

import com.isaachome.eshop.api.entiy.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    @Query(value = """
    SELECT i.* FROM 
    ecomm.cart c, ecomm.item i, ecomm.user u, ecomm.cart_item ci 
    WHERE u.id =: customerId AND c.user_id=u.id 
    AND c.id = ci.cart_id AND i.id=ci.item_id
""",nativeQuery = true)
    Iterable<ItemEntity> findByCustomerId(@Param("customerId") UUID customerId);

    @Modifying
    @Query(value = "DELETE FROM ecomm.cart_item WHERE item_id in (:ids) AND cart_id =:cartId",nativeQuery = true)
    void deleteCartItemJoinById(List<UUID> ids, UUID cartId);
}
