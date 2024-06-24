package com.pedrogomes.teste_go2win_backend.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedrogomes.teste_go2win_backend.domain.tax.Tax;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class TransferTableConfig {

    @Value("classpath:data/transferTable.json")
    private Resource resourceFile;

    @Bean
    public List<Tax> taxEntries() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = resourceFile.getInputStream()) {
            return objectMapper.readValue(inputStream, new TypeReference<List<Tax>>() {
            });
        }
    }
}
