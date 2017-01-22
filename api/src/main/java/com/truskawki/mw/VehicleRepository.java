package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import com.truskawki.mw.operations.VehicleRegistration;

import javax.servlet.http.HttpServletResponse;


public class VehicleRepository {

    public TruskawkiSimpleResponse addVehicle(HttpServletResponse response, Pojazd vehicleDTO, Wlasciciel ownerDTO) {
        VehicleRegistration vehicleRegistration = new VehicleRegistration(vehicleDTO, ownerDTO);
        return vehicleRegistration.performAction();
    }
}
