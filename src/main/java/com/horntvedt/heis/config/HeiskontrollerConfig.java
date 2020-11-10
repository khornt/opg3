package com.horntvedt.heis.config;

import com.horntvedt.heis.service.HeisService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeiskontrollerConfig {

    @Bean(name = "heiskontroller")
    public HeisService heiskontroller() {
        return new HeisService(5, "A");
    }
}
