/**
 * 
 */
package com.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Simarpreet Singh, created on 10 April 2020.
 *	InvalidRequestParameterException is to be thrown, if request parameter is not valid i.e. {null}/{Empty}/etc
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid request parameter.")
public class InvalidRequestParameterException extends Exception{

	private static final long serialVersionUID = -5844750161514126098L;

	public InvalidRequestParameterException(String message) {
		super(message);
	}

}
