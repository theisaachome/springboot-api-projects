package com.isaachome.eshop.api.entiy;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tag")
public class TagEntity extends BaseEntity{
    @NotNull(message = "Product name is required")
    @Basic(optional = false)
    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
