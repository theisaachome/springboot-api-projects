package com.isaachome.eshop.api.entiy;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID",updatable = false,nullable = false)
    private UUID id;
    private String itemName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
