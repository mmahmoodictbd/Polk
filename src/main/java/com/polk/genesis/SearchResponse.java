package com.polk.genesis;

import java.util.List;

public class SearchResponse {

	private final SearchRequest request;
	private final int returnCode;
	private final List<RoomDTO> rooms;

	private SearchResponse(Builder builder) {
		this.request = builder.request;
		this.returnCode = builder.returnCode;
		this.rooms = builder.rooms;
	}

	public SearchRequest getRequest() {
		return request;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public List<RoomDTO> getRooms() {
		return rooms;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nSearchResponse [request=");
		sb.append(request);
		sb.append(", \nreturnCode=");
		sb.append(returnCode);
		sb.append(", \nrooms=\n");
		for (RoomDTO roomDTO : rooms) {
			sb.append(roomDTO);
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}

	public static class Builder {

		private final SearchRequest request;
		private final int returnCode;
		private final List<RoomDTO> rooms;

		public Builder(SearchRequest request, int returnCode, List<RoomDTO> rooms) {
			this.request = request;
			this.returnCode = returnCode;
			this.rooms = rooms;
		}

		public SearchResponse build() {
			return new SearchResponse(this);
		}
	}
}
