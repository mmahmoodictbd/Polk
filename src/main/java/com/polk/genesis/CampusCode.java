package com.polk.genesis;

public enum CampusCode {

	ACT_TRAINING_CENTER("9", "ACT Training Center"), AIRSIDE_CENTER("A", "Airside Center"), ADVANCED_GLOBAL_TECH_CENTER(
			"C", "Advanced Global Tech Center"), JD_ALEXANDER_CENTER("J", "JD Alexander Center"), LAKELAND("L",
			"Lakeland"), NORTH_EAST_RIDGE("R", "North East Ridge"), WINTER_HAVEN("W", "Winter Haven");

	private String code;
	private String description;

	CampusCode(String code, String desc) {
		this.code = code;
		this.description = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
