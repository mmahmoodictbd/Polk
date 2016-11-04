package com.polk.genesis;

import java.util.HashMap;
import java.util.Map;

public class PolkConfigurations {

	public static final String BOOKING_SERVICE_ENDPOINT = "BookingServiceEndpoint";
	public static final String SEARCH_SERVICE_ENDPOINT = "SearchServiceEndpoint";
	public static final String SERVICE_CALL_TIMEOUT = "ServiceCallTimeOut";

	private static Map<String, String> conf = new HashMap<String, String>();

	static {
		// FIXME Should be loaded from prop file.
		conf.put("SearchServiceEndpoint", "http://suntest:8080/Webservices/xmlrt");
		conf.put("BookingServiceEndpoint", "http://suntest:8080/Webservices/xmlrt");
		conf.put("ServiceCallTimeOut", "60000");
	}

	public static String get(String key) {
		return conf.get(key);
	}

}
