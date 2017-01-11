package com.truskawki.mw.dal.operations;

import com.truskawki.mw.dal.DatabaseVehicleOperation;
import com.truskawki.mw.dal.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.lib.OwnerDTO;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.VehicleDTO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class VehicleRegistration extends DatabaseVehicleOperation {

	private VehicleDTO vehicleDTO;
	private OwnerDTO ownerDTO;

	private Logger logger = Logger.getLogger(VehicleRegistration.class);

	public VehicleRegistration(VehicleDTO vehicleDTO, OwnerDTO ownerDTO) {
		this.vehicleDTO = vehicleDTO;
		this.ownerDTO = ownerDTO;
	}

	@Override
	protected TruskawkiSimpleResponse mainAction() {
		try{
			vehicleMapper.addVehicleDocument(vehicleDTO);
			vehicleMapper.addOwner(ownerDTO);
			vehicleMapper.addVehicle();

			vehicleMapper.commit();
			databaseOperationResultEnum  = DatabaseOperationResultEnum.VEHICLE_REGISTERED_PROPERLY;
		} catch (Exception e){
			logger.log(Level.ERROR, e.toString());
			databaseOperationResultEnum  = DatabaseOperationResultEnum.VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR;
		}

		return new TruskawkiSimpleResponse();
	}
}
