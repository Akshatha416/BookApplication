package com.example.demo.error;

import java.time.LocalDateTime;

public class ErrorMessages {
	
	private  String message;
	private LocalDateTime time;
	private String exceptiontype;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getExceptiontype() {
		return exceptiontype;
	}
	public void setExceptiontype(String exceptiontype) {
		this.exceptiontype = exceptiontype;
	}
	public ErrorMessages(String message, LocalDateTime time, String exceptiontype) {
		super();
		this.message = message;
		this.time = time;
		this.exceptiontype = exceptiontype;
	}
	public ErrorMessages() {
		super();
	}
	

}
