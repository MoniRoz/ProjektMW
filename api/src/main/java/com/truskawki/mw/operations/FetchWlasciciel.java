package com.truskawki.mw.operations;

import com.truskawki.mw.VehicleMapper;
import com.truskawki.mw.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

public class FetchWlasciciel extends DatabaseComplexResponseOperation {

    private final Logger logger = Logger.getLogger(VehicleRegistration.class);
    private long pesel;

    public FetchWlasciciel(long pesel) {
        super(VehicleMapper.class);
        this.pesel = pesel;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
        TruskawkiSimpleResponse truskawkiSimpleResponse = new TruskawkiSimpleResponse();
        Wlasciciel wlasciciel = null;

        try{
            wlasciciel = ((VehicleMapper) mapper).getWlasciciel(pesel);
            databaseOperationResultEnum = DatabaseOperationResultEnum.OWNER_FETCHED_PROPERLY;
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
            databaseOperationResultEnum = DatabaseOperationResultEnum.OWNER_NOT_FETCHED_PROPERLY_DUE_TO_ERROR;
        }

        truskawkiSimpleResponse.setResponse(wlasciciel);

        return truskawkiSimpleResponse;
    }
}
