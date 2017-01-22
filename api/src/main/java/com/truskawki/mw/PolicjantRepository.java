package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import com.truskawki.mw.operations.FetchPojazd;
import com.truskawki.mw.operations.FetchPojazdForPolicjant;
import com.truskawki.mw.operations.FetchWlasciciel;
import com.truskawki.mw.operations.VehicleRegistration;

import javax.servlet.http.HttpServletResponse;


public class PolicjantRepository {

    public TruskawkiSimpleResponse getPojazd(String nr_vin, String nr_rejestracyjny) {
        FetchPojazdForPolicjant fetchPojazd = new FetchPojazdForPolicjant(nr_vin, nr_rejestracyjny);
        return fetchPojazd.performAction();
    }
}
