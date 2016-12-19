package com.malinki.pz.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malinki.pz.bll.VehicleOperations;
import com.malinki.pz.bll.VehicleUVM;

@RestController
@RequestMapping(value="/api")   
public class VehicleController {

	private Logger logger = Logger.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleOperations vehicleOperations;	
	
	
	@RequestMapping(value = "/starosta_samochod", method = RequestMethod.POST)
	public void addVehicle(@RequestBody String requestBody, HttpServletResponse response) {		
		vehicleOperations.addVehicle(response, parseToVehicleUVM(requestBody));
	}
		
	public VehicleUVM parseToVehicleUVM(String requestBody) {			
		ObjectMapper mapper = new ObjectMapper();
		VehicleUVM vehicle = null;
		
		try {
			vehicle = mapper.readValue(requestBody, VehicleUVM.class);
		} catch (IOException e) {
			logger.log(Level.ERROR, e.toString());
			throw new RuntimeException();
		}
				
		return vehicle;
	}
}
