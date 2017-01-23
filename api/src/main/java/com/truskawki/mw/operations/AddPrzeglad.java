package com.truskawki.mw.operations;

import com.truskawki.mw.OtherMapper;
import com.truskawki.mw.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.lib.Przeglad;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AddPrzeglad extends DatabaseComplexResponseOperation {

    private final Logger logger = Logger.getLogger(VehicleRegistration.class);
    private String nr_vin;
    private Przeglad przeglad;

    public AddPrzeglad(String nr_vin, Przeglad przeglad) {
        super(OtherMapper.class);
        this.nr_vin = nr_vin;
        this.przeglad = przeglad;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
        TruskawkiSimpleResponse truskawkiSimpleResponse = new TruskawkiSimpleResponse();

        try{
            ((OtherMapper) mapper).addPrzeglad(nr_vin, przeglad.getData_wystawienia(), przeglad.getData_waznosci(), przeglad.getWystawiajacy());
            databaseOperationResultEnum = DatabaseOperationResultEnum.PRZEGLAD_INSERTED_PROPERLY;
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
            databaseOperationResultEnum = DatabaseOperationResultEnum.PRZEGLAD_NOT_INSERTED_PROPERLY_DUE_TO_ERROR;
        }

        return truskawkiSimpleResponse;
    }
}
