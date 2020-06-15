package com.weather.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Exception Handler, and convert the error messages to generic error response.
 * @author singh
 *
 */
@ControllerAdvice
public class WeatherExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Exception handler for Weather API exceptions
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = WeatherAPIException.class)
	ResponseEntity<ErrorResponse> handleMyRestTemplateException(WeatherAPIException ex, HttpServletRequest request) {
		return new ResponseEntity<>(new ErrorResponse(ex, request.getRequestURI()), ex.getStatusCode());
	}
	
	

}
