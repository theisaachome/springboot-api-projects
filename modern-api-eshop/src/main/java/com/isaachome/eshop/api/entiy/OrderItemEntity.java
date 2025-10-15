package com.isaachome.eshop.api.entiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_item")
public class OrderItemEntity extends BaseEntity {
    @Column(name = "order_id")
    private UUID orderId;
    @Column(name = "item_id")
    private UUID itemId;

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public OrderItemEntity setOrderId(UUID orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderItemEntity setItemId(UUID itemId) {
        this.itemId = itemId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId)
                && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, itemId);
    }

    @Override
    public String toString() {
        return "OrderItemEntity{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }
}
