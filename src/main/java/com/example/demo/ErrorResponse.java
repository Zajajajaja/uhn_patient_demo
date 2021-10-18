package com.example.demo;

import org.springframework.http.HttpStatus;

/**
 * Custom error class to handle human readable messages and httpStatus Later
 * adds for 'error' possible that would encompass exception logging but not
 * really necessary with the small program here
 * 
 * @author Tom
 *
 */
public class ErrorResponse {
	private HttpStatus status;
	private String message;
//	private List<String> errors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public List<String> getErrors() {
//		return errors;
//	}
//
//	public void setErrors(List<String> errors) {
//		this.errors = errors;
//	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}