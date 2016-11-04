package com.polk.genesis;


public class SearchService {

	public SearchResponse search(SearchRequest request) {

		SoapSearchRequestBuilder soapRequest = new SoapSearchRequestBuilder();
		RequestSender sender = new SoapRequestSender();

		String soapReq = soapRequest.getSoapRequest(request.getUserId(), request.getStartDate(), request.getEndDate(),
				request.getStartTime(), request.getEndTime(), request.getReqDays(), request.getCapacity(),
				request.getCampusCenterCode(), request.getBuilderCodeOrNumber(), request.getRoomCodeOrNumber(),
				request.getSetupCode(), request.getStationTypeCode(), request.getUseCode(), request.getNextRoomKey());

		Logger.log("SOAP Request: " + soapReq);

		String response = null;
		try {
			response = sender.send(PolkConfigurations.get(PolkConfigurations.SEARCH_SERVICE_ENDPOINT), soapReq);
		} catch (Exception e) {
			Logger.log(e.getMessage());
			e.printStackTrace();
		}

		if (response == null) {
			return null;
		}

		Logger.log(XMLPrettyFormatUtil.format(response));

		SearchSoapResponseTransformer transformer = null;
		try {
			transformer = new SearchSoapResponseTransformer(request, response);
		} catch (GenesisAPIResponseMalformedException e) {
			e.printStackTrace();
		}

		return transformer.getSearchResponse();

	}
}
