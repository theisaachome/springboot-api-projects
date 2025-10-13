package com.isaachome.eshop.api.entiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import javax.swing.text.html.HTML;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{
    @NotNull(message = "Product name is required")
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "COUNT")
    private int count;
    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_TAG",
        joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private List<TagEntity> tags = Collections.emptyList();
    @OneToMany(mappedBy = "product")
    private List<ItemEntity> items;

    public ProductEntity(UUID id,
         @NotNull(message = "Product name is required.")String name,
                         String description, BigDecimal price, int count, String imageUrl, List<TagEntity> tags, List<ItemEntity> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
}
