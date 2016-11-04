package com.polk.genesis;

public class RoomDTO {

	private String room;
	private String building;
	private String setupStyle;
	private String stationType;
	private int headCount;
	private String campusCenter;
	private String campusCenterName;
	private String roomName;
	private String schedulingAuthority;
	private String buildingName;
	private String currentRoomUsage;

	public String getRoom() {
		return room;
	}

	public String getBuilding() {
		return building;
	}

	public String getSetupStyle() {
		return setupStyle;
	}

	public String getStationType() {
		return stationType;
	}

	public int getHeadCount() {
		return headCount;
	}

	public String getCampusCenter() {
		return campusCenter;
	}

	public String getCampusCenterName() {
		return campusCenterName;
	}

	public String getRoomName() {
		return roomName;
	}

	public String getSchedulingAuthority() {
		return schedulingAuthority;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public String getCurrentRoomUsage() {
		return currentRoomUsage;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public void setSetupStyle(String setupStyle) {
		this.setupStyle = setupStyle;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}

	public void setCampusCenter(String campusCenter) {
		this.campusCenter = campusCenter;
	}

	public void setCampusCenterName(String campusCenterName) {
		this.campusCenterName = campusCenterName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setSchedulingAuthority(String schedulingAuthority) {
		this.schedulingAuthority = schedulingAuthority;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setCurrentRoomUsage(String currentRoomUsage) {
		this.currentRoomUsage = currentRoomUsage;
	}

	@Override
	public String toString() {
		return "RoomDTO [room=" + room + ", building=" + building + ", setupStyle=" + setupStyle + ", stationType="
				+ stationType + ", headCount=" + headCount + ", campusCenter=" + campusCenter + ", campusCenterName="
				+ campusCenterName + ", roomName=" + roomName + ", schedulingAuthority=" + schedulingAuthority
				+ ", buildingName=" + buildingName + ", currentRoomUsage=" + currentRoomUsage + "]";
	}

}
