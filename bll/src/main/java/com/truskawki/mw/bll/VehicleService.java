package com.truskawki.mw.bll;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truskawki.mw.lib.OwnerUVM;
import com.truskawki.mw.lib.VehiclePost;
import com.truskawki.mw.lib.VehicleUVM;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.acl.Owner;

public class VehicleService {
    private Logger logger = Logger.getLogger(VehicleService.class);

    @Autowired
    private VehicleOperations vehicleOperations;

    public void addVehicle(String requestBody, HttpServletResponse response) {
        VehiclePost vehiclePost = parseToVehiclePost(requestBody);
        VehicleUVM vehicleUVM = vehiclePost.getSamochod();
        OwnerUVM ownerUVM = vehiclePost.getWlasciciel();

        if(validateAttributes(vehicleUVM, ownerUVM))
            vehicleOperations.addVehicle(response, vehicleUVM, ownerUVM);
        else
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    private VehiclePost parseToVehiclePost(String requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        VehiclePost vehiclePost = null;

        try {
            vehiclePost = mapper.readValue(requestBody, VehiclePost.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.toString());
            throw new RuntimeException();
        }

        return vehiclePost;
    }

    private boolean validateAttributes(VehicleUVM vehicleUVM, OwnerUVM ownerUVM){
        boolean validateVehicle =  !vehicleUVM.getBarwa_nadwozia().isEmpty()
                && !vehicleUVM.getD_nr_rejestracyjny().isEmpty()
                && !vehicleUVM.getMarka().isEmpty()
                && !vehicleUVM.getModel().isEmpty()
                && !vehicleUVM.getNr_kart_pojazdu().isEmpty()
                && !vehicleUVM.getNr_silnika().isEmpty()
                && !vehicleUVM.getNr_VIN().isEmpty()
                && !vehicleUVM.getRodzaj_pojazdu().isEmpty()
                && !vehicleUVM.getTyp().isEmpty()
                && vehicleUVM.getPrzebieg_p_w_km() != 0
                && vehicleUVM.getRok_produkcji() != 0;

        boolean validateOwner =  !ownerUVM.getImie().isEmpty()
                && !ownerUVM.getNazwisko().isEmpty()
                &&!ownerUVM.getUlica().isEmpty()
                && ownerUVM.getNr_domu() != 0
                && !ownerUVM.getKod_pocztowy().isEmpty()
                && !ownerUVM.getMiejscowosc().isEmpty()
                && ownerUVM.getPesel() != 0;

        return validateVehicle && validateOwner;
    }
}
