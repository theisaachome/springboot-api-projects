package com.isaachome.eshop.api.entiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {

    @Column(name = "NUMBER")
    private String number;
    @Column(name = "RESIDENCY")
    private String residency;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PINCODE")
    private String pincode;
}
