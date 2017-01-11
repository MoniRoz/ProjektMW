package com.truskawki.mw.bll;

import javax.servlet.http.HttpServletResponse;

import com.truskawki.mw.dal.VehicleRepository;
import com.truskawki.mw.lib.OwnerUVM;
import com.truskawki.mw.lib.VehicleUVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleOperations implements IVehicleRepository {

    @Autowired
    public VehicleRepository vehicleRepository;

    @Override
    public void addVehicle(HttpServletResponse response, VehicleUVM vehicleUVM, OwnerUVM ownerUVM) {
        vehicleRepository.addVehicle(
                response,
                VehicleConverter.fromVehicleUVMToVehicleDTO(vehicleUVM),
                OwnerConverter.fromOwnerUVMToOwnerDTO(ownerUVM));
    }
}
