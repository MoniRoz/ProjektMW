package com.truskawki.mw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    public StarostaService vehicleService() {
        return new StarostaService();
    }

    @Bean
    public StarostaRepository vehicleRepository() {
        return new StarostaRepository();
    }

    @Bean
    public PolicjantService policjantService() {
        return new PolicjantService();
    }

    @Bean
    public PolicjantRepository policjantRepository() {
        return new PolicjantRepository();
    }
}