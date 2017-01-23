package com.truskawki.mw.constants;

public enum DatabaseOperationResultEnum {
	VEHICLE_REGISTERED_PROPERLY("Vehicle registered properly"),
	VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR("Error occured during vehicle registering"),

	VEHICLE_FETCHED_PROPERLY("Vehicle fetched properly"),
	VEHICLE_NOT_FETCHED_PROPERLY_DUE_TO_ERROR("Vehicle not fetched properly due to error"),

	OWNER_FETCHED_PROPERLY("Owner fetched properly"),
	OWNER_NOT_FETCHED_PROPERLY_DUE_TO_ERROR("Owner not fetched properly due to error"),

	VEHICLES_FOR_POLICEMAN_FETCHED_PROPERLY("Vehicles for policeman fetched properly"),
	VEHICLES_FOR_POLICEMAN_NOT_FETCHED_PROPERLY_DUE_TO_ERROR("Vehicle for policeman not fetched properly due to error"),

	OWNERS_FOR_POLICEMAN_FETCHED_PROPERLY("Owners for policeman fetched properly"),
	OWNERS_FOR_POLICEMAN_NOT_FETCHED_PROPERLY_DUE_TO_ERROR("Owners for policeman not fetched properly due to error"),

	PRZEGLADY_FOR_POLICEMAN_FETCHED_PROPERLY("Przeglady for policeman fetched properly"),
	PRZEGLADY_FOR_POLICEMAN_NOT_FETCHED_PROPERLY_DUE_TO_ERROR("Przeglady for policeman not fetched properly due to error"),

	PRZEGLAD_INSERTED_PROPERLY("Przeglad inserted properly"),
	PRZEGLAD_NOT_INSERTED_PROPERLY_DUE_TO_ERROR("Przeglad not inserted properly due to error");

	private String name;

	DatabaseOperationResultEnum(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}



