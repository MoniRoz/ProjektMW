package com.truskawki.mw.dal;

import com.truskawki.mw.dal.operations.VehicleRegistration;
import com.truskawki.mw.lib.OwnerDTO;
import com.truskawki.mw.lib.VehicleDTO;

import javax.servlet.http.HttpServletResponse;


public class VehicleRepository {

    public void addVehicle(HttpServletResponse response, VehicleDTO vehicleDTO, OwnerDTO ownerDTO) {
        VehicleRegistration vehicleRegistration = new VehicleRegistration(vehicleDTO, ownerDTO);
        vehicleRegistration.performAction();
    }
}
