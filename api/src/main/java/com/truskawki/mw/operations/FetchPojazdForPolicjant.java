package com.truskawki.mw.operations;

import com.truskawki.mw.OtherMapper;
import com.truskawki.mw.PolicjantMapper;
import com.truskawki.mw.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class FetchPojazdForPolicjant extends DatabaseComplexResponseOperation {

    private final Logger logger = Logger.getLogger(VehicleRegistration.class);
    private String nr_vin;
    private String nr_rejestracyjny;

    public FetchPojazdForPolicjant(String nr_vin, String nr_rejestracyjny) {
        super(PolicjantMapper.class);
        this.nr_vin = nr_vin;
        this.nr_rejestracyjny = nr_rejestracyjny;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
        TruskawkiSimpleResponse truskawkiSimpleResponse = new TruskawkiSimpleResponse();
        Pojazd pojazd = null;

        try{
            pojazd = ((PolicjantMapper) mapper).getPojazd(nr_vin, nr_rejestracyjny);
            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_FETCHED_PROPERLY;
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_NOT_FETCHED_PROPERLY_DUE_TO_ERROR;
        }

        truskawkiSimpleResponse.setResponse(pojazd);

        return truskawkiSimpleResponse;
    }
}
