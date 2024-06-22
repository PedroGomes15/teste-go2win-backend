package com.pedrogomes.teste_go2win_backend.service;

import com.pedrogomes.teste_go2win_backend.domain.tax.Tax;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class TaxService {

    private final List<Tax> taxEntries;

    public TaxService(List<Tax> taxEntries) {
        this.taxEntries = taxEntries;
    }

}
