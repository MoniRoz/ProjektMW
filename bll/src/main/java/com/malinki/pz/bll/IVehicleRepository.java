package com.malinki.pz.bll;

import javax.servlet.http.HttpServletResponse;

public interface IVehicleRepository {
	public void addVehicle(HttpServletResponse response, VehicleUVM pojazd);
}
