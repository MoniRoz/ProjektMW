package com.truskawki.mw.controller;

import javax.servlet.http.HttpServletResponse;

import com.truskawki.mw.PolicjantService;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Przeglad;
import com.truskawki.mw.lib.Wlasciciel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class PolicjantController {

    @Autowired
    private PolicjantService policjantService;

    @RequestMapping(value = "/policjant/samochody", method = RequestMethod.GET)
    public List<Pojazd> getPojazd(@RequestParam String wartosc, HttpServletResponse response) {
        return policjantService.getPojazd(wartosc, response);
    }

    @RequestMapping(value = "/policjant/wlasciciele", method = RequestMethod.GET)
    public List<Wlasciciel> getWlasciciele(@RequestParam String vin, HttpServletResponse response) {
        return policjantService.getWlasciciele(vin, response);
    }

    @RequestMapping(value = "/policjant/przeglady", method = RequestMethod.GET)
    public List<Przeglad> getPrzeglady(@RequestParam String vin, HttpServletResponse response) {
        return policjantService.getPrzeglady(vin, response);
    }
}
