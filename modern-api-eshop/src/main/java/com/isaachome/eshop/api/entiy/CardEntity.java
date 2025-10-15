package com.isaachome.eshop.api.entiy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class CardEntity extends BaseEntity {

    @Column(name = "NUMBER")
    private String number;
    @Column(name = "EXPIRES")
    private String expires;
    @Column(name = "CVV")
    private String cvv;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",referencedColumnName = "ID",nullable = false)
    private UserEntity user;



    @OneToMany(mappedBy = "cardEntity",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<OrderEntity> orders;
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
