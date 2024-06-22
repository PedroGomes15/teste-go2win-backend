package com.pedrogomes.teste_go2win_backend.controller;

import com.pedrogomes.teste_go2win_backend.domain.transaction.Transaction;
import com.pedrogomes.teste_go2win_backend.domain.transaction.TransactionDTO;
import com.pedrogomes.teste_go2win_backend.domain.transaction.TransactionResponseDTO;
import com.pedrogomes.teste_go2win_backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transaction transaction = transactionService.createTransaction(transactionDTO);
        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO(transaction);
        return ResponseEntity.ok(transactionResponseDTO);
    }

    @GetMapping
    public List<TransactionResponseDTO> getListOfTransaction() {
        return transactionService.listAllTransaction()
                .stream()
                .map(TransactionResponseDTO::new)
                .collect(Collectors.toList());
    }
}
