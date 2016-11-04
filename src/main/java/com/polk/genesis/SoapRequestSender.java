package com.polk.genesis;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SoapRequestSender implements RequestSender {

	public String send1(String apiEndpoint, String reqXml) throws Exception {

		int timeout = Integer.parseInt(PolkConfigurations.get(PolkConfigurations.SERVICE_CALL_TIMEOUT));
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).build();

		HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		HttpPost post = new HttpPost(apiEndpoint);
		HttpEntity entity = new ByteArrayEntity(reqXml.getBytes("UTF-8"));
		post.setEntity(entity);

		
		Logger.log("Sending 'POST' request to URL : " + apiEndpoint);
		HttpResponse response = client.execute(post);


		Logger.log("Post parameters : " + XMLPrettyFormatUtil.format(reqXml));
		Logger.log("Response Code : " + response.getStatusLine().getStatusCode());

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new GenesisAPIException("API responded status code - " + response.getStatusLine().getStatusCode());
		}

		String respStr = response(response);
		Logger.log("Raw response - " + XMLPrettyFormatUtil.format(respStr));

		return respStr;
	}

	public String send(String apiEndpoint, String reqXml) throws Exception {

		Logger.log("Post parameters : " + XMLPrettyFormatUtil.format(reqXml));

		int timeout = Integer.parseInt(PolkConfigurations.get(PolkConfigurations.SERVICE_CALL_TIMEOUT));
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).build();

		URL url = new URL(apiEndpoint);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();

		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Content-Type", "application/xml");

		http.setConnectTimeout(timeout);

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(http.getOutputStream()));
		out.write(reqXml);
		out.close();

		StringBuilder sb = new StringBuilder();
		int HttpResult = http.getResponseCode();
		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
		} else {
			System.out.println(http.getResponseMessage());
		}

		int respCode = http.getResponseCode();
		http.disconnect();

		String respStr = sb.toString();


		Logger.log("Response Code : " + respCode);

		if (respCode != 200) {
			throw new GenesisAPIException("API responded status code - " + respCode);
		}

		Logger.log("Raw response - " + XMLPrettyFormatUtil.format(respStr));

		return respStr;
	}

	private String response(HttpResponse response) throws Exception {

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		return result.toString();
	}

}