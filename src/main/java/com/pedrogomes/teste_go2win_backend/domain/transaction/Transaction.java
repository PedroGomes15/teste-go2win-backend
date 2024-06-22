package com.pedrogomes.teste_go2win_backend.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transfers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "from_account", nullable = false, updatable = false)
    private String fromAccount;

    @Column(name = "destiny_account", nullable = false, updatable = false)
    private String destinyAccount;

    private float amount;

    @Column(name = "tax_amount", nullable = false, updatable = false)
    private float taxAmount;

    private LocalDate transferDate;

    public Transaction(TransactionDTO data, float tax) {
        this.createdAt = LocalDateTime.now();
        this.fromAccount = data.getFromAccount();
        this.destinyAccount = data.getDestinyAccount();
        this.amount = data.getAmount();
        this.taxAmount = tax;
        this.transferDate = data.getTransferDate();
    }
}
