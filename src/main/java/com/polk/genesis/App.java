package com.polk.genesis;

import java.util.Calendar;
import java.util.Date;

public class App {

	public static void main(String args[]) throws Exception {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 300);

		SearchRequest.Builder builder = new SearchRequest.Builder(SearchRequest.USER_ID.HIR_TEST, new Date(), c.getTime(), "0500am",
				"0600am", "UMTWRFS", 1, CampusCode.WINTER_HAVEN.getCode());
		builder.builderCodeOrNumber("");
		builder.roomCodeOrNumber("");
		builder.setupCode("");
		builder.stationTypeCode("");
		builder.nextRoomKey("");
		SearchRequest searchRequest = builder.build();

		SearchService service = new SearchService();
		SearchResponse searchResponse = service.search(searchRequest);

		Logger.log("SearchResponse:\n" + searchResponse);

		if (searchResponse.getRooms().size() == 0) {
			return;
		}

		RoomDTO roomDTO = searchResponse.getRooms().get(0);
		Logger.log("Booking this room - " + roomDTO);

		String sectionId = "H14169";
		BookingRequest bookingRequest = new BookingRequest.Builder(roomDTO.getCampusCenter(), roomDTO.getBuilding(),
				roomDTO.getRoom(), sectionId, EventTypeCode.AM_MEAL, "Morning meal", new Date(), new Date(), 5,
				"0500am", "0600am","110").build();//110 is the room use code

		BookingService bookingService = new BookingService();
		BookingResponse bookingResponse = bookingService.book(bookingRequest);
		Logger.log("BookingResponse:\n" + bookingResponse);
		
		bookingService.delete("H14169");
		
	}

}