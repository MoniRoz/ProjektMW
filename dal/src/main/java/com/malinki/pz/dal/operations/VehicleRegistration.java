package com.malinki.pz.dal.operations;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.malinki.pz.dal.DatabaseOperation;
import com.malinki.pz.dal.constants.DatabaseOperationResultEnum;
import com.malinki.pz.dal.domain.VehicleDTO;

public class VehicleRegistration extends DatabaseOperation{

	private VehicleDTO pojazd;
	private Logger logger = Logger.getLogger(VehicleRegistration.class);

	public VehicleRegistration(HttpServletResponse response, VehicleDTO pojazd) {
		super(response);
		this.pojazd = pojazd;
	}

	@Override
	protected void mainAction() {
		try{
			mapper.addVehicle(
					pojazd.getRodzaj_pojazdu(),
					pojazd.getMarka(),
					pojazd.getTyp(),
					pojazd.getModel(),
					pojazd.getRok_produkcji(),
					pojazd.getNr_VIN(),
					pojazd.getNr_silnika(),
					pojazd.getD_nr_rejestracyjny(),
					pojazd.getNr_kart_pojazdu(),
					pojazd.getPrzebieg_p_w_km(),
					pojazd.getBarwa_nadwozia());
			databaseOperationResultEnum  = DatabaseOperationResultEnum.VEHICLE_REGISTERED_PROPERLY;
		} catch (Exception e){
			logger.log(Level.ERROR, e.toString());
			databaseOperationResultEnum  = DatabaseOperationResultEnum.VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR;
		}
	}
}
