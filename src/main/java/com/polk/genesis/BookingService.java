package com.polk.genesis;

public class BookingService {

	public BookingResponse book(BookingRequest request) {

		SoapBookingRequestBuilder soapRequest = new SoapBookingRequestBuilder();
		RequestSender sender = new SoapRequestSender();

		String soapReq = soapRequest.getSoapRequest(request.getSiteLocalNumber(), request.getFacilityLocalNumber(),
				request.getInventoryKey(), request.getEventKey(), request.getEventTypeCode(), request.getEventTitle(),
				request.getEventStartDate(), request.getEventEndDate(), request.getHeadCount(),
				request.getScheduleStartTime(), request.getScheduleEndTime(), request.getCurrentRoomUsage());

		String response = null;
		try {
			response = sender.send(PolkConfigurations.get(PolkConfigurations.BOOKING_SERVICE_ENDPOINT), soapReq);
		} catch (Exception e) {
			Logger.log(e.getMessage());
			e.printStackTrace();
		}

		if (response == null) {
			return null;
		}

		Logger.log(XMLPrettyFormatUtil.format(response));

		BookingSoapResponseTransformer transformer = null;
		try {
			transformer = new BookingSoapResponseTransformer(request, response);
		} catch (GenesisAPIResponseMalformedException e) {
			e.printStackTrace();
		}

		return transformer.getBookingResponse();
	}

	public BookingDeleteResponse delete(String eventKey) {

		SoapBookingDeleteRequestBuilder soapRequest = new SoapBookingDeleteRequestBuilder();
		RequestSender sender = new SoapRequestSender();

		String soapReq = soapRequest.getSoapRequest(eventKey);

		String response = null;
		try {
			response = sender.send(PolkConfigurations.get(PolkConfigurations.BOOKING_SERVICE_ENDPOINT), soapReq);
		} catch (Exception e) {
			Logger.log(e.getMessage());
			e.printStackTrace();
		}

		if (response == null) {
			return null;
		}

		Logger.log(XMLPrettyFormatUtil.format(response));

		BookingDeleteSoapResponseTransformer transformer = null;
		try {
			transformer = new BookingDeleteSoapResponseTransformer(response);
		} catch (GenesisAPIResponseMalformedException e) {
			e.printStackTrace();
		}

		return transformer.getBookingResponse();

	}
}
