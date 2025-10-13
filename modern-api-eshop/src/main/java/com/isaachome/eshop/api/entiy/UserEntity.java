package com.isaachome.eshop.api.entiy;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID",updatable = false,nullable = false)
    private UUID id;
    private String username;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY,orphanRemoval = true)
    private com.isaachome.eshop.api.entiy.CartEntity cart;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public com.isaachome.eshop.api.entiy.CartEntity getCart() {
        return cart;
    }

    public void setCart(com.isaachome.eshop.api.entiy.CartEntity cart) {
        this.cart = cart;
    }
}
