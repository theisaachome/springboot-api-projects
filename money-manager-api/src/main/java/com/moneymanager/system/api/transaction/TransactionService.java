package com.moneymanager.system.api.transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto dto);
    TransactionDto updateTransaction(UUID transactionId, TransactionDto dto);
    void deleteTransaction(UUID transactionId);
    List<TransactionDto> getAllTransactions();
}
