package com.truskawki.mw.controller;

import javax.servlet.http.HttpServletResponse;

import com.truskawki.mw.StarostaService;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class StarostaController {

	@Autowired
	private StarostaService starostaService;

	@RequestMapping(value = "/starosta_samochod", method = RequestMethod.POST)
	public void addVehicle(@RequestBody String requestBody, HttpServletResponse response) {
		starostaService.addVehicle(requestBody, response);
	}

	@RequestMapping(value = "starosta/dane_wlasciciel", method = RequestMethod.GET)
	public Wlasciciel getWlasciciel(@RequestParam long pesel, HttpServletResponse response) {
		return starostaService.getWlasciciel(pesel, response);
	}

	@RequestMapping(value = "starosta/dane_samochod", method = RequestMethod.GET)
	public Pojazd getSamochod(@RequestParam String vin, HttpServletResponse response) {
		return starostaService.getPojazd(vin, response);
	}
}
