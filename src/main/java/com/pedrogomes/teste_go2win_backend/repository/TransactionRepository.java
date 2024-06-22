package com.pedrogomes.teste_go2win_backend.repository;

import com.pedrogomes.teste_go2win_backend.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
