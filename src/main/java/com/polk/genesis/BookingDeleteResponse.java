package com.polk.genesis;

public class BookingDeleteResponse {

	private final String returnCode;
	private final String returnMessage;

	private BookingDeleteResponse(Builder builder) {
		this.returnCode = builder.returnCode;
		this.returnMessage = builder.returnMessage;
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
		builder2.append("BookingResponse [returnCode=").append(returnCode).append(", returnMessage=")
				.append(returnMessage).append("]");
		return builder2.toString();
	}

	public static class Builder {

		private final String returnCode;
		private final String returnMessage;

		public Builder(String returnCode, String returnMessage) {
			this.returnCode = returnCode;
			this.returnMessage = returnMessage;
		}

		public BookingDeleteResponse build() {
			return new BookingDeleteResponse(this);
		}
	}
}
