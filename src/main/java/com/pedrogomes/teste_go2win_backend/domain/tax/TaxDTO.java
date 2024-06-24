package com.pedrogomes.teste_go2win_backend.domain.tax;

import lombok.Getter;

//Getters gerados automaticamento pelo 'lombok'
@Getter
public class TaxDTO {

    private int data_from;

    private int data_to;

    private float tax;

    private float money;

    public TaxDTO(Tax data) {
        this.data_from = data.getData_from();
        this.data_to = data.getData_to();
        this.tax = data.getTax();
        this.money = data.getMoney();
    }
}
