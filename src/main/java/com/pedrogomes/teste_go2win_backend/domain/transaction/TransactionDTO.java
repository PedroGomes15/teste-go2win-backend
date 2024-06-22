package com.pedrogomes.teste_go2win_backend.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TransactionDTO {

    private String fromAccount;

    private String destinyAccount;

    private float amount;

    private LocalDate transferDate;
}
