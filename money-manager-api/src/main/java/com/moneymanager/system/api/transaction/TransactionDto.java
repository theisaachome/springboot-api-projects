package com.moneymanager.system.api.transaction;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDto(
        UUID id,
        @NotNull(message = "Date cannot be null")
        LocalDateTime date,
        @NotNull(message = "Amount cannot be null")
        BigDecimal amount,
        @NotEmpty(message = "Category cannot be null")
        String category,
        @NotEmpty(message = "Account cannot be null")
        String account,
        @NotEmpty(message = "Note cannot be null")
        String note,
        @NotNull(message = "Transaction type cannot be null")
        TransactionType type,
        String description) {
}
