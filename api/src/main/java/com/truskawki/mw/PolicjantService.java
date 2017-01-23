package com.truskawki.mw;

import com.truskawki.mw.lib.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PolicjantService {

    @Autowired
    private PolicjantRepository policjantRepository;

    private Logger logger = Logger.getLogger(StarostaService.class);

    public List<Pojazd> getPojazd(String value, HttpServletResponse response) {
        TruskawkiSimpleResponse truskawkiSimpleResponse = null;
        int result;

        if(compareToNumerRejestracyjny(value))
            truskawkiSimpleResponse = policjantRepository.getPojazd(null, value);
        else if (compareToNumerVIN(value))
            truskawkiSimpleResponse = policjantRepository.getPojazd(value, null);
        else {
            truskawkiSimpleResponse = new TruskawkiSimpleResponse();
            truskawkiSimpleResponse.setResult(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        result = truskawkiSimpleResponse.getResult();
        response.setStatus(result);

        List<Pojazd> list = new ArrayList<>();

        if(result != HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
            list.add((Pojazd) truskawkiSimpleResponse.getResponse());

        return list;
    }

    public List<Wlasciciel> getWlasciciele(String vin, HttpServletResponse response) {
        TruskawkiSimpleResponse truskawkiSimpleResponse = null;
        int result;

        truskawkiSimpleResponse = policjantRepository.getWlasciciele(vin);

        result = truskawkiSimpleResponse.getResult();
        response.setStatus(result);

        return (List<Wlasciciel>) truskawkiSimpleResponse.getResponse();
    }

    public List<Przeglad> getPrzeglady(String vin, HttpServletResponse response) {
        TruskawkiSimpleResponse truskawkiSimpleResponse = null;
        int result;

        truskawkiSimpleResponse = policjantRepository.getPrzeglady(vin);

        result = truskawkiSimpleResponse.getResult();
        response.setStatus(result);

        return (List<Przeglad>) truskawkiSimpleResponse.getResponse();
    }


    private boolean compareToNumerRejestracyjny(String value) {
        String patternUsername = "^[A-Z0-9]{7}$";
        return Pattern.matches(patternUsername, value);
    }

    private boolean compareToNumerVIN(String value) {
        String patternUsername = "^[0-9A-HJ-NPR-Z]{17}$";
        return Pattern.matches(patternUsername, value);
    }
}
