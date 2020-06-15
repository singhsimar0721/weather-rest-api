/**
 * 
 */
package com.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Simarpreet Singh
 *	Custom Exception Handler to handle application exception/error responses
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class WeatherAPIException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7601469130956519791L;
	private HttpStatus statusCode;
	private String error;

	public WeatherAPIException(HttpStatus statusCode, String error) {
		super(error);
		this.statusCode = statusCode;
		this.error = error;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
