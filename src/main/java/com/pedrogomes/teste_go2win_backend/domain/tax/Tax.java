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

    public boolean isInInterval(int days) {
        return days >= this.data_from && days <= this.data_to;
    }

    public float calculateDecimalTax() {
        return tax / 100;
    }

}
