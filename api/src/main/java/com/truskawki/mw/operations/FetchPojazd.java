package com.truskawki.mw.operations;

import com.truskawki.mw.OtherMapper;
import com.truskawki.mw.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class FetchPojazd extends DatabaseComplexResponseOperation {

    private final Logger logger = Logger.getLogger(VehicleRegistration.class);
    private String vin;

    public FetchPojazd(String vin) {
        super(OtherMapper.class);
        this.vin = vin;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
        TruskawkiSimpleResponse truskawkiSimpleResponse = new TruskawkiSimpleResponse();
        Pojazd pojazd = null;

        try{
            pojazd = ((OtherMapper) mapper).getPojazd(vin);
            String rodzaj_pojazdu = ((OtherMapper) mapper).getRodzaj_pojazdu(vin);
            String marka = ((OtherMapper) mapper).getMarka(vin);

            pojazd.setRodzaj_pojazdu(rodzaj_pojazdu);
            pojazd.setMarka(marka);

            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_FETCHED_PROPERLY;
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_NOT_FETCHED_PROPERLY_DUE_TO_ERROR;
        }

        truskawkiSimpleResponse.setResponse(pojazd);

        return truskawkiSimpleResponse;
    }
}
