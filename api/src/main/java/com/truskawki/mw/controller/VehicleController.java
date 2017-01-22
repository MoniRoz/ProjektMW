package com.truskawki.mw.controller;

import javax.servlet.http.HttpServletResponse;

import com.truskawki.mw.VehicleService;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/starosta_samochod", method = RequestMethod.POST)
	public void addVehicle(@RequestBody String requestBody, HttpServletResponse response) {
		vehicleService.addVehicle(requestBody, response);
	}

	@RequestMapping(value = "starosta/dane_wlasciciel", method = RequestMethod.GET)
	public Wlasciciel getWlasciciel(@RequestParam long pesel, HttpServletResponse response) {
		return vehicleService.getWlasciciel(pesel, response);
	}

	@RequestMapping(value = "starosta/dane_samochod", method = RequestMethod.GET)
	public Pojazd getSamochod(@RequestParam long vin, HttpServletResponse response) {
		return vehicleService.getPojazd(vin, response);
	}
}
