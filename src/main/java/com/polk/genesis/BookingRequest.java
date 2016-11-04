package com.polk.genesis;

import java.util.Date;

public class BookingRequest {

	private final String siteLocalNumber;
	private final String facilityLocalNumber;
	private final String inventoryKey;
	private final String eventKey;
	private final EventTypeCode eventTypeCode;
	private final String eventTitle;
	private final Date eventStartDate;
	private final Date eventEndDate;
	private final int headCount;
	private final String scheduleStartTime;
	private final String scheduleEndTime;
	private final String currentRoomUsage;

	private BookingRequest(Builder builder) {
		this.siteLocalNumber = builder.siteLocalNumber;
		this.facilityLocalNumber = builder.facilityLocalNumber;
		this.inventoryKey = builder.inventoryKey;
		this.eventKey = builder.eventKey;
		this.eventTypeCode = builder.eventTypeCode;
		this.eventTitle = builder.eventTitle;
		this.eventStartDate = builder.eventStartDate;
		this.eventEndDate = builder.eventEndDate;
		this.headCount = builder.headCount;
		this.scheduleStartTime = builder.scheduleStartTime;
		this.scheduleEndTime = builder.scheduleEndTime;
		this.currentRoomUsage=builder.currentRoomUsage;
	}

	public String getSiteLocalNumber() {
		return siteLocalNumber;
	}

	public String getFacilityLocalNumber() {
		return facilityLocalNumber;
	}

	public String getInventoryKey() {
		return inventoryKey;
	}

	public String getEventKey() {
		return eventKey;
	}

	public EventTypeCode getEventTypeCode() {
		return eventTypeCode;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public int getHeadCount() {
		return headCount;
	}

	public String getScheduleStartTime() {
		return scheduleStartTime;
	}

	public String getScheduleEndTime() {
		return scheduleEndTime;
	}

	public String getCurrentRoomUsage() {
		return currentRoomUsage;
	}
	
	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("BookingRequest [siteLocalNumber=").append(siteLocalNumber).append(", facilityLocalNumber=")
				.append(facilityLocalNumber).append(", inventoryKey=").append(inventoryKey).append(", eventKey=")
				.append(eventKey).append(", eventTypeCode=").append(eventTypeCode).append(", eventTitle=")
				.append(eventTitle).append(", eventStartDate=").append(eventStartDate).append(", eventEndDate=")
				.append(eventEndDate).append(", headCount=").append(headCount).append(", scheduleStartTime=")
				.append(scheduleStartTime).append(", scheduleEndTime=").append(scheduleEndTime)
				.append(", currentRoomUsage=").append(currentRoomUsage).append("]");
		return builder2.toString();
	}


	public static class Builder {

		private String siteLocalNumber;
		private String facilityLocalNumber;
		private String inventoryKey;
		private String eventKey;
		private EventTypeCode eventTypeCode;
		private String eventTitle;
		private Date eventStartDate;
		private Date eventEndDate;
		private int headCount;
		private String scheduleStartTime;
		private String scheduleEndTime;
		private String currentRoomUsage;

		Builder(String siteLocalNumber, String facilityLocalNumber, String inventoryKey, String eventKey,
                EventTypeCode eventTypeCode, String eventTitle, Date eventStartDate, Date eventEndDate, int headCount,
                String scheduleStartTime, String scheduleEndTime, String currentRoomUsage) {
			this.siteLocalNumber = siteLocalNumber;
			this.facilityLocalNumber = facilityLocalNumber;
			this.inventoryKey = inventoryKey;
			this.eventKey = eventKey;
			this.eventTypeCode = eventTypeCode;
			this.eventTitle = eventTitle;
			this.eventStartDate = eventStartDate;
			this.eventEndDate = eventEndDate;
			this.headCount = headCount;
			this.scheduleStartTime = scheduleStartTime;
			this.scheduleEndTime = scheduleEndTime;
			this.currentRoomUsage = currentRoomUsage;
		}

		public BookingRequest build() {
			return new BookingRequest(this);
		}
	}

}
