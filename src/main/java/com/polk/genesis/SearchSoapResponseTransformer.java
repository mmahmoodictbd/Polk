package com.polk.genesis;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSoapResponseTransformer {

	private final Document soapResponseDoc;
	private int returnCode;
	private List<RoomDTO> rooms = new ArrayList<RoomDTO>();
	private SearchResponse response;

	public SearchSoapResponseTransformer(SearchRequest request, String soapResponse)
			throws GenesisAPIResponseMalformedException {

		this.soapResponseDoc = XMLUtil.buildDocument(soapResponse);

		if (this.soapResponseDoc == null) {
			Logger.log("Could not create Document from Genesis API response.");
			throw new GenesisAPIResponseMalformedException("Could not create Document from Genesis API response.");
		}

		NodeList retCodeNodes = soapResponseDoc.getElementsByTagName("RETURN-CODE");

		if (retCodeNodes.getLength() == 1) {
			this.returnCode = Integer.parseInt(retCodeNodes.item(0).getTextContent());
		} else {
			Logger.log("Genesis API response does not contains RETURN-CODE tag.");
			throw new GenesisAPIResponseMalformedException("Genesis API response does not contains RETURN-CODE tag.");
		}

		NodeList roomNodes = soapResponseDoc.getElementsByTagName("ROOM-ARRAY");

		if (roomNodes.getLength() == 0) {
			return;
		}

		for (int i = 0; i < roomNodes.getLength(); i++) {

			Node roomNode = roomNodes.item(i);

			Map<String, String> roomMap = new HashMap<String, String>();
			NodeList roomSpecNodes = roomNode.getChildNodes();
			for (int j = 0; j < roomSpecNodes.getLength(); j++) {
				roomMap.put(roomSpecNodes.item(j).getNodeName(), roomSpecNodes.item(j).getTextContent());
			}

			RoomDTO room = mapToRoomDto(roomMap);
			if (room != null) {
				rooms.add(mapToRoomDto(roomMap));
			}
		}

		SearchResponse.Builder builder = new SearchResponse.Builder(request, returnCode, rooms);
		this.response = builder.build();

	}

	public SearchResponse getSearchResponse() {
		return this.response;
	}

	private RoomDTO mapToRoomDto(Map<String, String> roomMap) {

		if (roomMap.get("ROOM") == null || roomMap.get("ROOM").trim().length() == 0) {
			return null;
		}

		RoomDTO room = new RoomDTO();
		room.setRoom(roomMap.get("ROOM"));
		room.setBuilding(roomMap.get("BUILDING"));
		room.setSetupStyle(roomMap.get("SETUP-STYLE"));
		room.setStationType(roomMap.get("STATION-TYPE"));
		room.setHeadCount(roomMap.get("HEAD-COUNT") != null ? Integer.parseInt(roomMap.get("HEAD-COUNT")) : 0);
		room.setCampusCenter(roomMap.get("CAMPUS-CENTER"));
		room.setCampusCenterName(roomMap.get("CAMPUS-CENTER-NAME"));
		room.setRoomName(roomMap.get("ROOM-NAME"));
		room.setSchedulingAuthority(roomMap.get("SCHEDULING-AUTHORITY"));
		room.setBuildingName(roomMap.get("BUILDING-NAME"));
		room.setCurrentRoomUsage(roomMap.get("CURRENT-ROOM-USAGE"));
		return room;
	}

}