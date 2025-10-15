package com.isaachome.eshop.api.entiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "shipments")
public class ShipmentEntity extends BaseEntity {
    @Column(name = "EST_DELIVERY_DATE")
    private String carrier;
    @Column(name = "CARRIER")
    private Timestamp esDeliveryDate;

    public ShipmentEntity setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

    public ShipmentEntity setEsDeliveryDate(Timestamp esDeliveryDate) {
        this.esDeliveryDate = esDeliveryDate;
        return this;
    }

    public String getCarrier() {
        return carrier;
    }

    public Timestamp getEsDeliveryDate() {
        return esDeliveryDate;
    }
}
