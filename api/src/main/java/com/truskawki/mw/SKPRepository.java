package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import com.truskawki.mw.operations.*;

import javax.servlet.http.HttpServletResponse;


public class SKPRepository {

    public TruskawkiSimpleResponse getPojazd(String nr_vin, String nr_rejestracyjny) {
        FetchPojazdForPolicjant fetchPojazd = new FetchPojazdForPolicjant(nr_vin, nr_rejestracyjny);
        return fetchPojazd.performAction();
    }

    public TruskawkiSimpleResponse getWlasciciele(String nr_vin) {
        FetchOwnersForPolicjant fetchOwnersForPolicjant = new FetchOwnersForPolicjant(nr_vin);
        return fetchOwnersForPolicjant.performAction();
    }

    public TruskawkiSimpleResponse getPrzeglady(String nr_vin) {
        FetchPrzegladyForPolicjant fetchPrzegladyForPolicjant = new FetchPrzegladyForPolicjant(nr_vin);
        return fetchPrzegladyForPolicjant.performAction();
    }
}
