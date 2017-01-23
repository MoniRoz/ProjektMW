package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Przeglad;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import com.truskawki.mw.operations.*;

import javax.servlet.http.HttpServletResponse;


public class SKPRepository {

    public TruskawkiSimpleResponse addPrzeglad(String nr_vin, Przeglad przeglad) {
        AddPrzeglad addPrzeglad = new AddPrzeglad(nr_vin, przeglad);
        return addPrzeglad.performAction();
    }
}
