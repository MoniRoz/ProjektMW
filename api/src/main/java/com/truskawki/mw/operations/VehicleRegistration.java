package com.truskawki.mw.operations;

import com.truskawki.mw.VehicleMapper;
import com.truskawki.mw.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class VehicleRegistration extends DatabaseComplexResponseOperation {

    private final Logger logger = Logger.getLogger(VehicleRegistration.class);
    private Pojazd pojazd;
    private Wlasciciel wlasciciel;


    public VehicleRegistration(Pojazd pojazd, Wlasciciel wlasciciel) {
        super(VehicleMapper.class);
        this.pojazd = pojazd;
        this.wlasciciel = wlasciciel;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
        TruskawkiSimpleResponse truskawkiSimpleResponse = new TruskawkiSimpleResponse();

        try{
            ((VehicleMapper)mapper).insertRodzaj_pojazdu(pojazd.getRodzaj_pojazdu());
            ((VehicleMapper)mapper).insertMarka(pojazd.getMarka());
            ((VehicleMapper)mapper).insertPojazd(pojazd);
            ((VehicleMapper)mapper).insertWlasciciel(wlasciciel);
            ((VehicleMapper)mapper).insertPosiadanie();
            ((VehicleMapper)mapper).insertDowodRejestracyjny();
            ((VehicleMapper)mapper).insertKartaPojazdu();

            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_REGISTERED_PROPERLY;
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR;
        }

        return new TruskawkiSimpleResponse();
    }
}
