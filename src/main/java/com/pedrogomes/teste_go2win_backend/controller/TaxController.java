package com.pedrogomes.teste_go2win_backend.controller;

import com.pedrogomes.teste_go2win_backend.domain.tax.Tax;
import com.pedrogomes.teste_go2win_backend.domain.tax.TaxDTO;
import com.pedrogomes.teste_go2win_backend.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tax")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping
    public List<TaxDTO> getTaxes() throws IOException {
        return taxService.getTaxEntries().stream().map(TaxDTO::new).collect(Collectors.toList());
    }
}