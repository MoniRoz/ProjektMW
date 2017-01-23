package com.truskawki.mw.operations;

import com.truskawki.mw.StarostaMapper;
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
        super(StarostaMapper.class);
        this.pojazd = pojazd;
        this.wlasciciel = wlasciciel;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
        TruskawkiSimpleResponse truskawkiSimpleResponse = new TruskawkiSimpleResponse();

        try{
            boolean isPojazdAlreadyUsed = getBoolean(((StarostaMapper) mapper).isPojazdAlreadyUsed(pojazd.getNr_VIN()));
            boolean isWlascicielAlreadyUsed = getBoolean(((StarostaMapper) mapper).isWlascicielAlreadyUsed(wlasciciel.getPesel()));

            if(isWlascicielAlreadyUsed && isPojazdAlreadyUsed){
                ((StarostaMapper)mapper).updateWlasciciel(wlasciciel);
                ((StarostaMapper)mapper).updatePojazd(pojazd);

                int idPrzegladu = ((StarostaMapper)mapper).getPrzegladID(pojazd.getNr_VIN());

                ((StarostaMapper)mapper).updateDowodRejestracyjny(pojazd.getNr_VIN());
                ((StarostaMapper)mapper).updatePosiadanie(pojazd.getNr_VIN(), wlasciciel.getPesel());
                ((StarostaMapper)mapper).insertUpdateDowodRejestracyjny(pojazd.getNr_VIN(), wlasciciel.getPesel());
                ((StarostaMapper)mapper).insertUpdatePosiadania(pojazd.getNr_VIN(), wlasciciel.getPesel());

                ((StarostaMapper)mapper).updatePrzeglad(idPrzegladu, pojazd.getNr_VIN(), wlasciciel.getPesel());
            }
            else if(isWlascicielAlreadyUsed && !isPojazdAlreadyUsed){
                ((StarostaMapper)mapper).updateWlasciciel(wlasciciel);
                ((StarostaMapper)mapper).insertRodzaj_pojazdu(pojazd.getRodzaj_pojazdu());
                ((StarostaMapper)mapper).insertMarka(pojazd.getMarka());
                ((StarostaMapper)mapper).insertPojazd(pojazd);

                int pojazdCurrval = ((StarostaMapper)mapper).getPojazdCurrval();
                int wlascicielID = ((StarostaMapper)mapper).getWlascicielID(wlasciciel.getPesel());

                ((StarostaMapper)mapper).insertPosiadanie(pojazdCurrval, wlascicielID);
                ((StarostaMapper)mapper).insertKartaPojazdu(pojazdCurrval, wlascicielID);
                ((StarostaMapper)mapper).insertNewDowodRejestracyjny(pojazdCurrval, wlascicielID);
                ((StarostaMapper)mapper).insertPrzeglad();
            }
            else if(!isWlascicielAlreadyUsed && isPojazdAlreadyUsed){
                ((StarostaMapper)mapper).insertWlasciciel(wlasciciel);
                ((StarostaMapper)mapper).updatePojazd(pojazd);

                int idPrzegladu = ((StarostaMapper)mapper).getPrzegladID(pojazd.getNr_VIN());

                ((StarostaMapper)mapper).updateDowodRejestracyjny2(pojazd.getNr_VIN());
                ((StarostaMapper)mapper).updatePosiadanie2(pojazd.getNr_VIN());
                ((StarostaMapper)mapper).insertUpdateDowodRejestracyjny(pojazd.getNr_VIN(), wlasciciel.getPesel());
                ((StarostaMapper)mapper).insertUpdatePosiadania(pojazd.getNr_VIN(), wlasciciel.getPesel());

                ((StarostaMapper)mapper).updatePrzeglad(idPrzegladu, pojazd.getNr_VIN(), wlasciciel.getPesel());
            }
            else if(!isPojazdAlreadyUsed && !isWlascicielAlreadyUsed){
                ((StarostaMapper)mapper).insertRodzaj_pojazdu(pojazd.getRodzaj_pojazdu());
                ((StarostaMapper)mapper).insertMarka(pojazd.getMarka());
                ((StarostaMapper)mapper).insertPojazd(pojazd);
                ((StarostaMapper)mapper).insertWlasciciel(wlasciciel);

                int pojazdID = ((StarostaMapper)mapper).getPojazdID(pojazd.getNr_VIN());
                int wlascicielID = ((StarostaMapper)mapper).getWlascicielID(wlasciciel.getPesel());

                ((StarostaMapper)mapper).insertPosiadanie(pojazdID, wlascicielID);
                ((StarostaMapper)mapper).insertKartaPojazdu(pojazdID, wlascicielID);
                ((StarostaMapper)mapper).insertNewDowodRejestracyjny(pojazdID, wlascicielID);
                ((StarostaMapper)mapper).insertPrzeglad();
            }

            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_REGISTERED_PROPERLY;
        } catch (Exception e){
            logger.log(Level.ERROR, e.toString());
            databaseOperationResultEnum = DatabaseOperationResultEnum.VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR;
        }

        return new TruskawkiSimpleResponse();
    }
}
