package com.isaachome.eshop.api.entiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @NotNull(message = "User name is reuqired")
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "USER_STATUS")
    private String userStatus;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private List<AddressEntity> addresses = Collections.emptyList();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<CardEntity> cards;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY,orphanRemoval = true)
    private CartEntity cart;

    @OneToMany(mappedBy = "userEntity",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<OrderEntity> orders = Collections.emptyList();



    public UserEntity setUserEntityId(UUID id) {
        this.id = id;
        return this;
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
