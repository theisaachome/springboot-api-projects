package com.isaachome.eshop.api.entiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class PaymentEntity extends BaseEntity {

    @Column(name = "AUTHORIZED")
    private boolean authorized;
    @Column(name = "MESSAGE")
    private String message;
    @OneToOne(mappedBy = "paymentEntity")
    private OrderEntity orderEntity;

    public PaymentEntity setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    public PaymentEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public PaymentEntity setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
        return this;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public String getMessage() {
        return message;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }
}
