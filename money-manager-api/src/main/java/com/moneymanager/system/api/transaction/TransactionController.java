package com.moneymanager.system.api.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {


    @PostMapping
    public ResponseEntity<String> registerTransaction() {
        return ResponseEntity.ok("Transaction registered successfully");
    }

    @PutMapping("/transactionId")
    public ResponseEntity<String> updateTransaction(@PathVariable("transactionId") String transactionId) {
        return ResponseEntity.ok("Transaction updated successfully");
    }
}
