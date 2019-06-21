package com.training.borsa.xml;

import javax.xml.ws.Endpoint;

public class Main {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1/test", new MyWebService());
	
	}
}
