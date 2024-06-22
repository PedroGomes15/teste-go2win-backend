package com.pedrogomes.teste_go2win_backend.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {

    private UUID id;

    private LocalDateTime createdAt;

    private String fromAccount;

    private String destinyAccount;

    private float amount;

    private float taxAmount;

    private LocalDate transferDate;

    public TransactionResponseDTO(Transaction data) {
        this(data.getId(), data.getCreatedAt(), data.getFromAccount(), data.getDestinyAccount(), data.getAmount(), data.getTaxAmount(), data.getTransferDate());
    }
}
