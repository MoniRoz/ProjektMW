package com.malinki.pz.bll;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.malinki.pz.dal.VehicleRepository;

@Configuration
public class BllConfig {
       
    @Bean
    public VehicleRepository userRepository() {
        return new VehicleRepository();
    }
}