package com.truskawki.mw.bll;

import com.truskawki.mw.lib.OwnerUVM;
import com.truskawki.mw.lib.VehicleUVM;

import javax.servlet.http.HttpServletResponse;

public interface IVehicleRepository {
    public void addVehicle(HttpServletResponse response, VehicleUVM vehicleUVM, OwnerUVM ownerUVM);
}
