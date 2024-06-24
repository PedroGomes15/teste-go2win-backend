package com.pedrogomes.teste_go2win_backend.service;

import com.pedrogomes.teste_go2win_backend.domain.tax.MoneyWithTaxDTO;
import com.pedrogomes.teste_go2win_backend.domain.transaction.Transaction;
import com.pedrogomes.teste_go2win_backend.domain.transaction.TransactionDTO;
import com.pedrogomes.teste_go2win_backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TaxService taxService;

    public Transaction createTransaction(TransactionDTO transactionDTO) {
        MoneyWithTaxDTO tax = taxService.CalculateTaxValue(transactionDTO.getAmount(), transactionDTO.getTransferDate());
        Transaction transaction = new Transaction(transactionDTO, tax.getTotalTaxAmount());
        transactionRepository.save(transaction);
        return transaction;
    }

    public List<Transaction> listAllTransaction() {
        return transactionRepository.findAll();
    }
}
