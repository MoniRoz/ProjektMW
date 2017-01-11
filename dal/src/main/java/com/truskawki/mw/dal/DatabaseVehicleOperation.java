package com.truskawki.mw.dal;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.truskawki.mw.dal.constants.DatabaseOperationResultEnum;

public abstract class DatabaseVehicleOperation extends DatabaseOperation{
	private Logger logger = Logger.getLogger(DatabaseVehicleOperation.class);
	protected VehicleMapper vehicleMapper;
	protected DatabaseOperationResultEnum databaseOperationResultEnum;

	public TruskawkiSimpleResponse performAction() {
		InputStream inputStream = openInputStream();
		SqlSession session = establishSession(inputStream);
		vehicleMapper = session.getMapper(VehicleMapper.class);

		TruskawkiSimpleResponse truskawkiSimpleResponse;
		truskawkiSimpleResponse = mainAction();
		truskawkiSimpleResponse.setResult(getResultCode());

		session.close();
		closeInputStream(inputStream);

		return truskawkiSimpleResponse;
	}

	private int getResultCode() {
		int result = 0;

		logger.log(Level.INFO, databaseOperationResultEnum.getName());

		switch (databaseOperationResultEnum){
			case VEHICLE_REGISTERED_PROPERLY:
				result = HttpServletResponse.SC_OK;
				break;
			case VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR:
				result = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
				break;
			default:
				break;
		}

		return result;
	}

	abstract protected TruskawkiSimpleResponse mainAction();
}
