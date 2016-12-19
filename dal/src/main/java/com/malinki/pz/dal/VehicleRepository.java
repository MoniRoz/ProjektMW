package com.malinki.pz.dal;

import javax.servlet.http.HttpServletResponse;

import com.malinki.pz.dal.domain.VehicleDTO;
import com.malinki.pz.dal.operations.VehicleRegistration;

public class VehicleRepository {

	public void addVehicle(HttpServletResponse response, VehicleDTO user) {
		VehicleRegistration vehicleRegistration = new VehicleRegistration(response, user);
		vehicleRegistration.performAction();
	}
}
