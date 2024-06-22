package com.pedrogomes.teste_go2win_backend.service;

import com.pedrogomes.teste_go2win_backend.domain.tax.MoneyWithTaxDTO;
import com.pedrogomes.teste_go2win_backend.domain.tax.Tax;
import com.pedrogomes.teste_go2win_backend.exception.NotAllowedTransactionException;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Getter
public class TaxService {

    private final List<Tax> taxEntries;

    public TaxService(List<Tax> taxEntries) {
        this.taxEntries = taxEntries;
    }

    public MoneyWithTaxDTO CalculateTaxValue(float value, LocalDate transactionDate) {
        int daysUntil = DaysUntil(transactionDate);
        Tax tax = getTaxFromTime(daysUntil).orElseThrow(() ->
                new NotAllowedTransactionException("Transação de acima de 50 dias não é permitida - (tempo total: " + (daysUntil) + ")"
                ));

        float finalTaxAmount = (value * tax.calculateDecimalTax()) + tax.getMoney();
        float totalAmount = value + finalTaxAmount;

        return new MoneyWithTaxDTO(totalAmount, finalTaxAmount, tax);
    }

    public Optional<Tax> getTaxFromTime(int days) {
        return taxEntries.stream().filter(entry -> entry.isInInterval(days)).findFirst();
    }

    public int DaysUntil(LocalDate futureDate) {
        LocalDate today = LocalDate.now();
        if (futureDate.isBefore(today)) {
            throw new IllegalArgumentException("A data fornecida é anterior à data atual.");
        }
        return (int) ChronoUnit.DAYS.between(today, futureDate);
    }


}
