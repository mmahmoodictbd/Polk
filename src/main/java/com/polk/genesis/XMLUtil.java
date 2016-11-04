package com.polk.genesis;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class XMLUtil {

	private XMLUtil() {
		throw new IllegalStateException("Util class can not be initialized.");
	}

	public static Document buildDocument(String xml) {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setIgnoringComments(true);
		dbFactory.setNamespaceAware(false);
		DocumentBuilder dBuilder = null;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			Logger.log(e.getMessage());
			e.printStackTrace();
		}

		try {
			return dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
		} catch (SAXException e) {
			Logger.log(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			Logger.log(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
}