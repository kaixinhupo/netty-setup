package com.ydhl.mp.model.request.factory;

import org.json.JSONObject;

import com.ydhl.mp.model.request.Request;

public interface RequestFactory<T extends Request> {
	T create(JSONObject json);
}
