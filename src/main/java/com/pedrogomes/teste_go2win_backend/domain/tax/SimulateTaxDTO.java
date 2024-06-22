package com.pedrogomes.teste_go2win_backend.domain.tax;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimulateTaxDTO {

    float amount;

    LocalDate transferDate;
}
