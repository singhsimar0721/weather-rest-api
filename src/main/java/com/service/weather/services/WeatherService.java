/**
 * 
 */
package com.service.weather.services;

import org.springframework.http.ResponseEntity;

import com.service.weather.domain.object.WeatherDO;

/**
 * @author Simarpreet Singh, created on 10 April 2020
 * 
 * Interface is responsible to store Service Operations related to Weather API,
 *
 */
public interface WeatherService {

	public ResponseEntity<WeatherDO> getWeatherForCity(String city);
	public ResponseEntity<WeatherDO> getWeatherForCityInCountry(String city,String country);
	public ResponseEntity<WeatherDO> getWeatherForCityInCountryCode(String city,String country, String iso_code);
	public ResponseEntity<WeatherDO> getWeatherForLatLon(Float lat,Float lon);
}
