package com.truskawki.mw.bll;

import com.truskawki.mw.dal.VehicleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BllConfig {
       
    @Bean
    public VehicleRepository vehicleRepository() {
        return new VehicleRepository();
    }
}