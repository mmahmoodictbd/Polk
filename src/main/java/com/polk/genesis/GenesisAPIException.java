package com.polk.genesis;

public class GenesisAPIException extends Exception {

	private static final long serialVersionUID = 1L;

	public GenesisAPIException() {
	}

	public GenesisAPIException(String message) {
		super(message);
	}

	public GenesisAPIException(Throwable cause) {
		super(cause);
	}

	public GenesisAPIException(String message, Throwable cause) {
		super(message, cause);
	}

}
