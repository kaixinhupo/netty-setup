package com.ydhl.mp.handler;

import java.util.Hashtable;

import org.json.JSONObject;

import com.ydhl.mp.model.request.Request;
import com.ydhl.mp.model.request.factory.PrintRequestFactory;
import com.ydhl.mp.model.request.factory.RequestFactory;

public class RequestParser {
	private static Hashtable<Integer, RequestFactory<?>> factories = new Hashtable<Integer, RequestFactory<?>>();
	
	static {
		factories.put(1, new PrintRequestFactory());
	}
	
	public Request process(JSONObject json) {
		try {
			int code = json.getInt("code");
			RequestFactory<?> factory = factories.get(code);
			if(factory!=null) {
				return factory.create(json);
			}
		} catch (Exception e) {
			throw new RuntimeException("illegal request");
		}
		return null;
	}
	
}
