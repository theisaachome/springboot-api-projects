package com.moneymanager.system.api.transaction;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDto> registerTransaction(@Valid @RequestBody TransactionDto dto) {
        var result = transactionService.createTransaction(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/transactionId")
    public ResponseEntity<TransactionDto> updateTransaction(@PathVariable("transactionId") UUID transactionId,
                                                           @Valid @RequestBody TransactionDto dto) {
        var result= transactionService.updateTransaction(transactionId,dto);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getTransactions() {
        var result= transactionService.getAllTransactions();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
