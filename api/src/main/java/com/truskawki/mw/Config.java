package com.truskawki.mw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    public VehicleService vehicleService() {
        return new VehicleService();
    }

    @Bean
    public VehicleRepository vehicleRepository() {
        return new VehicleRepository();
    }
}