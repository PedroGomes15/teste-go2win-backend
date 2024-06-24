package com.pedrogomes.teste_go2win_backend.domain.tax;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Getters e setters e construtores basicos gerados automaticamento pelo 'lombok'
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoneyWithTaxDTO {

    float totalAmount;

    float totalTaxAmount;

    Tax tax;
}
