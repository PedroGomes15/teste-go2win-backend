package com.pedrogomes.teste_go2win_backend.domain.tax;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tax {

    private int data_from;

    private int data_to;

    private float tax;

    private float money;

}
