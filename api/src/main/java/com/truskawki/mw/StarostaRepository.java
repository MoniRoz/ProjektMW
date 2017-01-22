package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import com.truskawki.mw.operations.FetchPojazd;
import com.truskawki.mw.operations.FetchWlasciciel;
import com.truskawki.mw.operations.VehicleRegistration;

import javax.servlet.http.HttpServletResponse;


public class StarostaRepository {

    public TruskawkiSimpleResponse addVehicle(Pojazd pojazd, Wlasciciel wlasciciel) {
        VehicleRegistration vehicleRegistration = new VehicleRegistration(pojazd, wlasciciel);
        return vehicleRegistration.performAction();
    }

    public TruskawkiSimpleResponse getWlasciciel(long pesel) {
        FetchWlasciciel fetchWlasciciel = new FetchWlasciciel(pesel);
        return fetchWlasciciel.performAction();
    }

    public TruskawkiSimpleResponse getPojazd(String vin) {
        FetchPojazd fetchPojazd = new FetchPojazd(vin);
        return fetchPojazd.performAction();
    }
}
