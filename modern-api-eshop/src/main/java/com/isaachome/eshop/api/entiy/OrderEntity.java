package com.isaachome.eshop.api.entiy;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private UserEntity userEntity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID",referencedColumnName = "ID",insertable = false,updatable = false)
    private AddressEntity addressEntity;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "PAYMENT_ID",referencedColumnName = "ID")
    private PaymentEntity paymentEntity;
    @OneToOne
    @JoinColumn(name = "SHIPMENT_ID",referencedColumnName = "ID")
    private ShipmentEntity shipment;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CARD_ID",referencedColumnName = "ID")
    private CardEntity cardEntity;
    @Column(name = "ORDER_DATE")
    private Timestamp orderDate;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "ORDER_ITEM",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<ItemEntity> items = Collections.emptyList();
    @OneToOne(mappedBy = "orderEntity")
    private AuthorizationEntity authorizationEntity;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public ShipmentEntity getShipment() {
        return shipment;
    }

    public void setShipment(ShipmentEntity shipment) {
        this.shipment = shipment;
    }

    public CardEntity getCardEntity() {
        return cardEntity;
    }

    public void setCardEntity(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public AuthorizationEntity getAuthorizationEntity() {
        return authorizationEntity;
    }

    public void setAuthorizationEntity(AuthorizationEntity authorizationEntity) {
        this.authorizationEntity = authorizationEntity;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", total=" + total +
                ", status=" + status +
                ", userEntity=" + userEntity +
                ", addressEntity=" + addressEntity +
                ", paymentEntity=" + paymentEntity +
                ", shipment=" + shipment +
                ", cardEntity=" + cardEntity +
                ", orderDate=" + orderDate +
                ", items=" + items +
                ", authorizationEntity=" + authorizationEntity +
                '}';
    }
}
