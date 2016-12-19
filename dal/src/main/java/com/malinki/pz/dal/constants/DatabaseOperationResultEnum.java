package com.malinki.pz.dal.constants;

public enum DatabaseOperationResultEnum {
	VEHICLE_REGISTERED_PROPERLY("User registered properly"),
	VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR("Error occured during vehicle registering");
		
	private String name;

	DatabaseOperationResultEnum(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}



