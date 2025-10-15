package com.isaachome.eshop.api.entiy;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID",updatable = false,nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",referencedColumnName = "ID")
    private ProductEntity product;

    @Column(name = "UNIT_PRICE")
    private BigDecimal price;
    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToMany(mappedBy ="items",fetch = FetchType.LAZY)
    private List<CartEntity> cart;

    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    private List<OrderEntity> orders;

    public ItemEntity setProduct(ProductEntity product) {
        this.product = product;
        return this;
    }

    public ItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ItemEntity setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemEntity setCart(List<CartEntity> cart) {
        this.cart = cart;
        return this;
    }

    public ItemEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemEntity that = (ItemEntity) o;
        return quantity == that.quantity && product.equals(that.product) && Objects
                .equals(price, that.price);// && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, price, quantity);//, cart);
    }

    public UUID getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<CartEntity> getCart() {
        return cart;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }
}
