package com.polk.genesis;

import java.util.Date;

public class SearchRequest {

	static enum USER_ID {
		HIR_PROD, HIR_TEST
	}

	private final USER_ID userId;
	private final Date startDate;
	private final Date endDate;
	private final String startTime;
	private final String endTime;
	private final String reqDays;
	private final int capacity;
	private final String campusCenterCode;

	private String builderCodeOrNumber;
	private String roomCodeOrNumber;
	private String setupCode;
	private String stationTypeCode;
	private String useCode;
	private String nextRoomKey;

	private SearchRequest(Builder builder) {
		this.userId = builder.userId;
		this.startDate = builder.startDate;
		this.endDate = builder.endDate;
		this.startTime = builder.startTime;
		this.endTime = builder.endTime;
		this.reqDays = builder.reqDays;
		this.capacity = builder.capacity;
		this.campusCenterCode = builder.campusCenterCode;

		this.builderCodeOrNumber = builder.builderCodeOrNumber;
		this.roomCodeOrNumber = builder.roomCodeOrNumber;
		this.setupCode = builder.setupCode;
		this.stationTypeCode = builder.stationTypeCode;
		this.useCode = builder.useCode;
		this.nextRoomKey = builder.nextRoomKey;
	}

	public USER_ID getUserId() {
		return userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getReqDays() {
		return reqDays;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getCampusCenterCode() {
		return campusCenterCode;
	}

	public String getBuilderCodeOrNumber() {
		return builderCodeOrNumber;
	}

	public String getRoomCodeOrNumber() {
		return roomCodeOrNumber;
	}

	public String getSetupCode() {
		return setupCode;
	}

	public String getStationTypeCode() {
		return stationTypeCode;
	}

	public String getUseCode() {
		return useCode;
	}

	public String getNextRoomKey() {
		return nextRoomKey;
	}

	@Override
	public String toString() {
		return "\nSearchRequest [userId=" + userId + ",\nstartDate=" + startDate + ",\nendDate=" + endDate
				+ ",\nstartTime=" + startTime + ",\nendTime=" + endTime + ",\nreqDays=" + reqDays + ",\ncapacity="
				+ capacity + ",\ncampusCenterCode=" + campusCenterCode + ",\nbuilderCodeOrNumber="
				+ builderCodeOrNumber + ",\nroomCodeOrNumber=" + roomCodeOrNumber + ",\nsetupCode=" + setupCode
				+ ",\nstationTypeCode=" + stationTypeCode + ",\nuseCode=" + useCode + ",\nnextRoomKey=" + nextRoomKey
				+ "]";
	}

	public static class Builder {

		private USER_ID userId;
		private Date startDate;
		private Date endDate;
		private String startTime;
		private String endTime;
		private String reqDays;
		private int capacity;
		private String campusCenterCode;

		private String builderCodeOrNumber;
		private String roomCodeOrNumber;
		private String setupCode;
		private String stationTypeCode;
		private String useCode;
		private String nextRoomKey;

		Builder(USER_ID userId, Date startDate, Date endDate, String startTime, String endTime, String reqDays,
                int capacity, String campusCenterCode) {
			this.userId = userId;
			this.startDate = startDate;
			this.endDate = endDate;
			this.startTime = startTime;
			this.endTime = endTime;
			this.reqDays = reqDays;
			this.capacity = capacity;
			this.campusCenterCode = campusCenterCode;
		}

		Builder builderCodeOrNumber(String builderCodeOrNumber) {
			this.builderCodeOrNumber = builderCodeOrNumber;
			return this;
		}

		Builder roomCodeOrNumber(String roomCodeOrNumber) {
			this.roomCodeOrNumber = roomCodeOrNumber;
			return this;
		}

		Builder setupCode(String setupCode) {
			this.setupCode = setupCode;
			return this;
		}

		Builder stationTypeCode(String stationTypeCode) {
			this.stationTypeCode = stationTypeCode;
			return this;
		}

		Builder useCode(String useCode) {
			this.useCode = useCode;
			return this;
		}

		Builder nextRoomKey(String nextRoomKey) {
			this.nextRoomKey = nextRoomKey;
			return this;
		}

		public SearchRequest build() {
			return new SearchRequest(this);
		}
	}

}
