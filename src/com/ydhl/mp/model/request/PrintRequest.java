package com.ydhl.mp.model.request;

public class PrintRequest extends Request {

	private static final int REQUEST_CODE = 1;
	private String title;
	
	public PrintRequest() {
		super(REQUEST_CODE);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "PrintRequest [title=" + title + ", super=" + super.toString() + "]";
	}

	
}
