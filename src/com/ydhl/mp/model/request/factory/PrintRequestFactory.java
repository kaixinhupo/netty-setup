package com.ydhl.mp.model.request.factory;

import org.json.JSONObject;

import com.ydhl.mp.model.request.PrintRequest;

public class PrintRequestFactory implements RequestFactory<PrintRequest> {

	private static PrintRequestFactory instance = new PrintRequestFactory();
	
	public static PrintRequestFactory getInstance() {
		return instance;
	}

	@Override
	public PrintRequest create(JSONObject json) {
		PrintRequest request = new PrintRequest();
		request.setTitle(json.getString("title"));
		return request;
	}

}
