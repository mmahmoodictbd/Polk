package com.polk.genesis;

public class BookingResponse {

	private final BookingRequest request;
	private final String returnCode;
	private final String returnMessage;

	private BookingResponse(Builder builder) {
		this.request = builder.request;
		this.returnCode = builder.returnCode;
		this.returnMessage = builder.returnMessage;
	}

	public BookingRequest getRequest() {
		return request;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("BookingResponse [request=").append(request).append(", returnCode=").append(returnCode)
				.append(", returnMessage=").append(returnMessage).append("]");
		return builder2.toString();
	}

	public static class Builder {

		private final BookingRequest request;
		private final String returnCode;
		private final String returnMessage;

		public Builder(BookingRequest request, String returnCode, String returnMessage) {
			this.request = request;
			this.returnCode = returnCode;
			this.returnMessage = returnMessage;
		}

		public BookingResponse build() {
			return new BookingResponse(this);
		}
	}
}
