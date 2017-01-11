package com.truskawki.mw;

import com.truskawki.mw.bll.BllConfig;
import com.truskawki.mw.bll.VehicleOperations;
import com.truskawki.mw.bll.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BllConfig.class)
public class ApiConfig {
    
    @Bean
    public VehicleOperations vehicleOperations() {
        return new VehicleOperations();
    }

    @Bean
    public VehicleService vehicleService() {
        return new VehicleService();
    }
}