package com.polk.genesis;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class BookingSoapResponseTransformer {

	private final Document soapResponseDoc;
	private String returnCode;
	private String returnMessage;
	private BookingResponse response;

	public BookingSoapResponseTransformer(BookingRequest request, String soapResponse)
			throws GenesisAPIResponseMalformedException {

		this.soapResponseDoc = XMLUtil.buildDocument(soapResponse);

		if (this.soapResponseDoc == null) {
			Logger.log("Could not create Document from Genesis API response.");
			throw new GenesisAPIResponseMalformedException("Could not create Document from Genesis API response.");
		}

		NodeList retCodeNodes = soapResponseDoc.getElementsByTagName("RETURN-CODE");

		if (retCodeNodes.getLength() == 1) {
			this.returnCode = retCodeNodes.item(0).getTextContent();
		} else {
			Logger.log("Genesis API response does not contains RETURN-CODE tag.");
			throw new GenesisAPIResponseMalformedException("Genesis API response does not contains RETURN-CODE tag.");
		}

		NodeList retMsgNodes = soapResponseDoc.getElementsByTagName("RETURN-MESSAGE");

		if (retMsgNodes.getLength() == 1) {
			this.returnMessage = retMsgNodes.item(0).getTextContent();
		} else {
			Logger.log("Genesis API response does not contains RETURN-MESSAGE tag.");
			throw new GenesisAPIResponseMalformedException("Genesis API response does not contains RETURN-MESSAGE tag.");
		}

		BookingResponse.Builder builder = new BookingResponse.Builder(request, returnCode, returnMessage);
		this.response = builder.build();

	}

	public BookingResponse getBookingResponse() {
		return this.response;
	}

}