package com.boot.anilg.exception;

import java.util.Date;

public class CustomErrorDetails {
	
	private String message;
	private Date date;
	private String errorDetails;
	
	public CustomErrorDetails(String message, Date date, String errorDetails) {
		super();
		this.message = message;
		this.date = date;
		this.errorDetails = errorDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	
	
}
