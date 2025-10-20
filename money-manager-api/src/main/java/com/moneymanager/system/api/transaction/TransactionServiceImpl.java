package com.moneymanager.system.api.transaction;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto createTransaction(TransactionDto dto) {
        if(dto == null) {
            throw new IllegalArgumentException("TransactionDto cannot be null");
        }
        var savedEntity = transactionRepository.save(mapToEntity(dto));
        return this.mapToDto(savedEntity);
    }

    @Override
    public TransactionDto updateTransaction(UUID transactionId, TransactionDto dto) {
        var existingEntity = transactionRepository.findById(transactionId)
                .orElseThrow(()-> new EntityNotFoundException("Transaction not found with id: " + transactionId));
        // Update fields
        existingEntity.setAmount(dto.amount())
                .setCategory(dto.category())
                .setAccount(dto.account())
                .setNote(dto.note())
                .setDescription(dto.description().isEmpty()? null : dto.description());
        var updatedEntity = transactionRepository.save(existingEntity);
        return this.mapToDto(updatedEntity);
    }

    @Override
    public void deleteTransaction(UUID transactionId) {
         var existingEntity = transactionRepository.findById(transactionId)
                .orElseThrow(()-> new EntityNotFoundException("Transaction not found with id: " + transactionId));
            transactionRepository.delete(existingEntity);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
       return transactionRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }
    private TransactionEntity mapToEntity(TransactionDto dto) {
        TransactionEntity entity = new TransactionEntity()
                .setAmount(dto.amount())
                .setCategory(dto.category())
                .setAccount(dto.account())
                .setNote(dto.note())
                .setType(dto.type())
                .setDescription(dto.description().isEmpty()? null : dto.description());
        return entity;
    }
    private  TransactionDto mapToDto(TransactionEntity entity) {
        TransactionDto dto = new TransactionDto(
                entity.getId(),
                entity.getDate(),
                entity.getAmount(),
                entity.getCategory(),
                entity.getAccount(),
                entity.getNote(),
                entity.getType(),
                entity.getDescription() == null ? "" : entity.getDescription()
        );
        return dto;
    }
}
