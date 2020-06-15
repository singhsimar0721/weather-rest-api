/**
 * 
 */
package com.weather.exception;

/**
 * @author Simarpreet Singh, 10 April 2020.
 * 
 * Custom class to hold error responses, from exceptions.
 *
 */
public class ErrorResponse {


	  /** 
	   * HTTP Status Code 
	  */
	  private int status;

	  /** 
	   * HTTP Reason phrase 
	   */
	  private String error;

	  /** 
	   * A message that describe the error thrown when calling the downstream API 
	   */
	  private String message;

	  /** 
	   * URI that has been called 
	   */
	  private String path;

	  public ErrorResponse(WeatherAPIException ex, String path) {
	    this.status = ex.getStatusCode().value();
	    this.error = ex.getStatusCode().getReasonPhrase();
	    this.message = ex.getError();
	    this.path = path;
	  }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	  
	  
}
