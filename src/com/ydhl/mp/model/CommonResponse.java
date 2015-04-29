package com.ydhl.mp.model;

import org.json.JSONObject;

public class CommonResponse {
	private int code;
	private String msg;
	private String description;
	
	public CommonResponse(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("code",code);
		json.put("msg", msg);
		json.put("desc", description);
		return json.toString();
	}
}
