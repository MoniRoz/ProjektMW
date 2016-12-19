package com.malinki.pz.bll;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinki.pz.dal.VehicleRepository;

@Service
public class VehicleOperations implements IVehicleRepository {
	
	@Autowired
	public VehicleRepository pojazdRepository;
			
	@Override
	public void addVehicle(HttpServletResponse response, VehicleUVM pojazd) {	
		pojazdRepository.addVehicle(response, VehicleConverter.fromVehicleUVMToVehicleDTO(pojazd));
	}
}
