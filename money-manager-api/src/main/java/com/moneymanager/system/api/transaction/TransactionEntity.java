package com.moneymanager.system.api.transaction;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @CreationTimestamp
    @Column(name = "DATE",nullable = false)
    private LocalDateTime date;
    @Column(name = "AMOUNT",nullable = false)
    private BigDecimal amount;
    @Column(name = "CATEGORY",nullable = false)
    private String category;
    private String account;
    private String note;
    private String description;
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getAccount() {
        return account;
    }

    public String getNote() {
        return note;
    }

    public String getDescription() {
        return description;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TransactionEntity setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public TransactionEntity setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public TransactionEntity setCategory(String category) {
        this.category = category;
        return this;
    }

    public TransactionEntity setAccount(String account) {
        this.account = account;
        return this;
    }

    public TransactionEntity setNote(String note) {
        this.note = note;
        return this;
    }

    public TransactionEntity setDescription(String description) {
        this.description = description;
        return this;
    }
    public TransactionEntity setType(TransactionType type) {
        this.type = type;
        return this;
    }

    public TransactionType getType() {
        return type;
    }
}
