package com.truskawki.mw.controller;

import javax.servlet.http.HttpServletResponse;

import com.truskawki.mw.PolicjantService;
import com.truskawki.mw.SKPService;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Przeglad;
import com.truskawki.mw.lib.Wlasciciel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class SKPController {

    @Autowired
    private SKPService SKPService;

    @RequestMapping(value = "/skp/samochod_przeglad", method = RequestMethod.POST)
    public void getPojazd(@RequestBody String requestBody, HttpServletResponse response) {
        SKPService.addPrzeglad(requestBody, response);
    }
}
