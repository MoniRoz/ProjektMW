package com.truskawki.mw.operations;

import com.truskawki.mw.OtherMapper;
import com.truskawki.mw.PolicjantMapper;
import com.truskawki.mw.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Przeglad;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

public class FetchPrzegladyForPolicjant extends DatabaseComplexResponseOperation {

    private final Logger logger = Logger.getLogger(VehicleRegistration.class);
    private String nr_vin;

    public FetchPrzegladyForPolicjant(String nr_vin) {
        super(PolicjantMapper.class);
        this.nr_vin = nr_vin;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
        TruskawkiSimpleResponse truskawkiSimpleResponse = new TruskawkiSimpleResponse();
        List<Przeglad> wlascicielList = null;

        try{
            wlascicielList = ((PolicjantMapper) mapper).getPrzeglady(nr_vin);
            databaseOperationResultEnum = DatabaseOperationResultEnum.PRZEGLADY_FOR_POLICEMAN_FETCHED_PROPERLY;
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
            databaseOperationResultEnum = DatabaseOperationResultEnum.PRZEGLADY_FOR_POLICEMAN_NOT_FETCHED_PROPERLY_DUE_TO_ERROR;
        }

        truskawkiSimpleResponse.setResponse(wlascicielList);

        return truskawkiSimpleResponse;
    }
}
