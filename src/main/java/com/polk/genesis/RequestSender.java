package com.polk.genesis;

public interface RequestSender {
	public String send(String apiEndpoint, String reqXml) throws Exception;
}