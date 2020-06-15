/**
 * 
 */
package com.weather.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

/**
 * @author Simarpreet Singh, created on 10 April 2020.
 *
 *	Weather API Handler, matches the error structure for that specific API,then extract the error message
 *	Throws Weather API Exception with status code and error message.
 */
public class WeatherAPIErrorHandler extends DefaultResponseErrorHandler{

	@Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	    if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
	      try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
	        String httpBodyResponse = reader.lines().collect(Collectors.joining(""));
	        String errorMessage = httpBodyResponse;
	        throw new WeatherAPIException(response.getStatusCode(), errorMessage);
	      }
	    }
	  }
}
