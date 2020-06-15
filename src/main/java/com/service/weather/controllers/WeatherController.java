/**
 * 
 */
package com.service.weather.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.weather.domain.object.WeatherDO;
import com.service.weather.services.WeatherService;
import com.weather.exception.InvalidRequestParameterException;

/**
 * @author Simarpreet Singh, created on 10 April 2020.
 * 
 *	Weather Controller : All operations related to Weather will be routed by this controller.
 *
 */
@RestController
@RequestMapping("/service/weather")
public class WeatherController {

	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	private WeatherService weatherService;

	/**
	 * Handles request to get Weather details by city name only
	 * @param city
	 * @return ResponseEntity
	 * @throws InvalidRequestParameterException 
	 */
	@GetMapping("/{city}")
	public ResponseEntity<WeatherDO> getWeatherForCity(@PathVariable String city) throws InvalidRequestParameterException {
		logger.info("Request Recieved: Get Weather Details for City - "+city);
		boolean status=false;
		if(city==null || city.trim().isEmpty()) {
			logger.info("Invalid Request: Missing parameter {city}. ");
			throw new InvalidRequestParameterException("Invalid Request: Missing parameter {city}");
		}
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = weatherService.getWeatherForCity(city);
		status=true;
		logger.info("Request Prcessed: Weather of City Status: "+status);
		return ResponseEntity.accepted().body(weatherResp.getBody());
	}

	/**
	 * Handles request to get Weather details by city and country name only
	 * @param city
	 * @param country
	 * @return ResponseEntity
	 * @throws InvalidRequestParameterException 
	 */
	@GetMapping("/{city}/{country}")
	public ResponseEntity<WeatherDO> getWeatherForCityInCountry(@PathVariable String city,@PathVariable String country) throws InvalidRequestParameterException {
		logger.debug("Request Recieved: Get Weather Details for City - "+city+" in Country - "+country);
		boolean status=false;
		if(city==null || city.trim().isEmpty()) {
			logger.info("Invalid Request: Missing parameter {city}. ");
			throw new InvalidRequestParameterException("Invalid Request: Missing parameter {city}");
		}
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = weatherService.getWeatherForCityInCountry(city,country);
		status=true;
		logger.debug("Request Prcessed: Weather of City/Country Status: "+status);
		return ResponseEntity.accepted().body(weatherResp.getBody());
	}	


	/**
	 * Handles request to get Weather details by city name, country name and ISO-code only
	 * @param city
	 * @param country
	 * @param iso_code
	 * @return ResponseEntity
	 * @throws InvalidRequestParameterException 
	 */
	@GetMapping("/{city}/{country}/{iso_code}")
	public ResponseEntity<WeatherDO> getWeatherForCityInCountryCode(@PathVariable String city,@PathVariable String country, @PathVariable String iso_code) throws InvalidRequestParameterException {
		logger.debug("Request Recieved: Get Weather Details for City - "+city+" in Country - "+country+" with ISO code - "+iso_code);
		boolean status=false;
		if(city==null || city.trim().isEmpty()) {
			logger.info("Invalid Request: Missing parameter {city}. ");
			throw new InvalidRequestParameterException("Invalid Request: Missing parameter {city}");
		}
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = weatherService.getWeatherForCityInCountryCode(city,country,iso_code);
		status=true;
		logger.debug("Request Prcessed: Weather of City/Country/ISO-Code Status: "+status);
		return ResponseEntity.accepted().body(weatherResp.getBody());
	}
	
	/**
	 * Handles request to get Weather details by Latitude and Longitude.
	 * @param latitude
	 * @param longitude
	 * @return ResponseEntity
	 */
	@GetMapping("/latitude/{lat}/longitude/{lon}")
	public ResponseEntity<WeatherDO> getWeatherForLatLon(@PathVariable float lat,@PathVariable float lon) {
		logger.debug("Request Recieved: Get Weather Details for Latitude - "+lat+", Longitude - "+lon);
		boolean status=false;
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = weatherService.getWeatherForLatLon(lat, lon);
		status=true;
		logger.debug("Request Prcessed: Weather for Lat/Lon Status: "+status);
		return ResponseEntity.accepted().body(weatherResp.getBody());
	}

}
