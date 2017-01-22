package com.truskawki.mw;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.PojazdPost;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PolicjantService {

    @Autowired
    private PolicjantRepository policjantRepository;

    private Logger logger = Logger.getLogger(StarostaService.class);

    public Pojazd getPojazd(String value, HttpServletResponse response) {
        TruskawkiSimpleResponse truskawkiSimpleResponse = null;
        int result;

        if(value.length() == 7)                     //nr rejestracyjny
            truskawkiSimpleResponse = policjantRepository.getPojazd(null, value);
        else                                        // nr_vin
            truskawkiSimpleResponse = policjantRepository.getPojazd(value, null);

        result = truskawkiSimpleResponse.getResult();
        response.setStatus(result);

        return (Pojazd) truskawkiSimpleResponse.getResponse();
    }

    private PojazdPost parseToVehiclePost(String requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PojazdPost vehiclePost = null;

        try {
            vehiclePost = mapper.readValue(requestBody, PojazdPost.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.toString());
            throw new RuntimeException();
        }

        return vehiclePost;
    }

    private boolean validateAttributes(Pojazd pojazd, Wlasciciel wlascicel){
//        boolean validateVehicle =  !pojazd.getBarwa_nadwozia().isEmpty()
//                && !pojazd.getD_nr_rejestracyjny().isEmpty()
//                && !pojazd.getMarka().isEmpty()
//                && !pojazd.getModel().isEmpty()
//                && !pojazd.getNr_kart_pojazdu().isEmpty()
//                && !pojazd.getNr_silnika().isEmpty()
//                && !pojazd.getNr_VIN().isEmpty()
//                && !pojazd.getRodzaj_pojazdu().isEmpty()
//                && !pojazd.getTyp().isEmpty()
//                && pojazd.getPrzebieg_p_w_km() != 0
//                && pojazd.getRok_produkcji() != 0;
//
//        boolean validateOwner =  !wlascicel.getImie().isEmpty()
//                && !wlascicel.getNazwisko().isEmpty()
//                &&!wlascicel.getUlica().isEmpty()
//                && wlascicel.getNr_domu() != 0
//                && !wlascicel.getKod_pocztowy().isEmpty()
//                && !wlascicel.getMiejscowosc().isEmpty()
//                && wlascicel.getPesel() != 0;
//
//        return validateVehicle && validateOwner;

        return true;
    }
}
