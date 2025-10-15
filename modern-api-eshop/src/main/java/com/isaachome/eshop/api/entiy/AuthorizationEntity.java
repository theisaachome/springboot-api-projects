package com.isaachome.eshop.api.entiy;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "authorization")
public class AuthorizationEntity extends BaseEntity {
    @Column(name = "AUTHORIZED")
    private boolean authorization;
    @Column(name = "TIME")
    private Timestamp time;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "ERROR")
    private String error;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID",referencedColumnName = "id")
    private OrderEntity orderEntity;

    public boolean isAuthorization() {
        return authorization;
    }

    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
