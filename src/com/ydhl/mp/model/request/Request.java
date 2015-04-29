package com.ydhl.mp.model.request;

public abstract class Request {
	private int requestCode;
	
	public Request(int requestCode) {
		this.requestCode = requestCode;
	}
	
	public int getRequestCode() {
		return requestCode;
	}

	@Override
	public String toString() {
		return "Request [requestCode=" + requestCode + "]";
	}
}
