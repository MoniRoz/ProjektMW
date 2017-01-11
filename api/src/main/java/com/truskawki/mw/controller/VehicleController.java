package com.truskawki.mw.controller;

import javax.servlet.http.HttpServletResponse;

import com.truskawki.mw.bll.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/starosta_samochod", method = RequestMethod.POST)
	public void addVehicle(@RequestBody String requestBody, HttpServletResponse response) {
		requestBody = requestBody.replace("Samo", "samo");	// do usuniecia
		requestBody = requestBody.replace("Wlas", "wlas");  // do usuniecia

		vehicleService.addVehicle(requestBody, response);
	}
}
