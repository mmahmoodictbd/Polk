package com.polk.genesis;

public class GenesisAPIResponseMalformedException extends Exception {

	private static final long serialVersionUID = 1L;

	public GenesisAPIResponseMalformedException() {
	}

	public GenesisAPIResponseMalformedException(String message) {
		super(message);
	}

	public GenesisAPIResponseMalformedException(Throwable cause) {
		super(cause);
	}

	public GenesisAPIResponseMalformedException(String message, Throwable cause) {
		super(message, cause);
	}

}
