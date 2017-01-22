package com.truskawki.mw.constants;

public enum DatabaseOperationResultEnum {
	VEHICLE_REGISTERED_PROPERLY("Vehicle registered properly"),
	VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR("Error occured during vehicle registering"),

	VEHICLE_FETCHED_PROPERLY("Vehicle fetched properly"),
	VEHICLE_NOT_FETCHED_PROPERLY_DUE_TO_ERROR("Vehicle not fetched properly due to error"),

	OWNER_FETCHED_PROPERLY("Owner fetched properly"),
	OWNER_NOT_FETCHED_PROPERLY_DUE_TO_ERROR("Owner not fetched properly due to error");

	private String name;

	DatabaseOperationResultEnum(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}



