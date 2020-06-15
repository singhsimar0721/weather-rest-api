package com.service.weather.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.weather.domain.object.WeatherDO;
import com.service.weather.util.WeatherConstants;

/**
 * ALL Service Operations related to WeatherService implemented here only.
 * 
 * @author Simarpreet Singh, 10 April 2020.
 *
 */
@Service
public class GenericWeatherService implements WeatherService{

	private static final Logger logger = LoggerFactory.getLogger(GenericWeatherService.class);

	@Value("${weather.api.key}")
	private String apiKey;

	@Value("${weather.api.base.uri}")
	private String baseURI;

	@Autowired
	private RestTemplate restTemplate;


	/**
	 * Creates a weather object, from weather details received from weather API.
	 *
	 * @param city
	 * @return ResponseEntity
	 * @throws 
	 */
	@Cacheable(value="cityWeather", key="#city")
	public ResponseEntity<WeatherDO> getWeatherForCity(String city) {
		logger.info("Invoke service method for Weather of City: "+city);
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = restTemplate.getForEntity(prepareURL(city), WeatherDO.class, city);
		logger.info("Invoked service method for City Weather complete");
		return weatherResp;
	}
	
	/**
	 * Creates a weather object, from weather details received from weather API for City in country only.
	 *
	 * @param city
	 * @return ResponseEntity
	 * @throws 
	 */
	@Cacheable(value="cityCountryWeather", key="#city")
	public ResponseEntity<WeatherDO> getWeatherForCityInCountry(String city,String country) {
		logger.info("Invoke service method for Weather of City: "+city+", Country: "+country);
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = restTemplate.getForEntity(prepareURL(city,country), WeatherDO.class, city);
		logger.info("Invoked service method for City/Country Weather complete");
		return weatherResp;
	}
	
	/**
	 * Creates a weather object, from weather details received from weather API for City in country and ISO code.
	 *
	 * @param city
	 * @return ResponseEntity
	 * @throws 
	 */
	@Cacheable(value="cityCountryIsoWeather", key="#city")
	public ResponseEntity<WeatherDO> getWeatherForCityInCountryCode(String city,String country, String iso_code) {
		logger.info("Invoke service method for Weather of City: "+city+", Country: "+country+", ISO Code: "+iso_code);
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = restTemplate.getForEntity(prepareURL(city,country,iso_code), WeatherDO.class, city);
		logger.info("Invoked service method for City/Country/ISO Weather complete");
		return weatherResp;
	}
	
	/**
	 * Creates a weather object, from weather details received from weather API for Latitude and Longitude.
	 *
	 * @param lat and lon
	 * @return ResponseEntity
	 * @throws 
	 */
	@Cacheable(value="latlonWeather", key="#lat.toString().concat('-').concat(#lon.toString())")
	public ResponseEntity<WeatherDO> getWeatherForLatLon(Float lat,Float lon) {
		logger.info("Invoke service method for Weather of Latitude: "+lat+", Longitude: "+lon);
		ResponseEntity<WeatherDO> weatherResp = null;
		weatherResp = restTemplate.getForEntity(prepareURLForLatLon(lat,lon), WeatherDO.class, lat);
		logger.info("Invoked service method for Weather of Lat/Lon complete");
		return weatherResp;
	}

	/**
	 * Helper method to prepare URL Strings for City only
	 * @param city
	 * @return String URL
	 */
	private String prepareURL(String city) {
		logger.info("Preparing URL.");
		String url = baseURI + WeatherConstants.KEY_CITY + city+ WeatherConstants.AMP + WeatherConstants.KEY_APP_ID + apiKey;
		logger.info("Prepared URL: "+url);
		return url;
	}
	
	/**
	 * Helper method to prepare URL Strings for City, Country only
	 * @param city
	 * @return String URL
	 */
	private String prepareURL(String city, String country) {
		logger.info("Preparing URL.");
		String url = baseURI + WeatherConstants.KEY_CITY + city+","+country+ WeatherConstants.AMP + WeatherConstants.KEY_APP_ID + apiKey;
		logger.info("Prepared URL: "+url);
		return url;
	}
	
	/**
	 * Helper method to prepare URL Strings for City only
	 * @param city
	 * @return String URL
	 */
	private String prepareURL(String city,String country, String iso_code) {
		logger.info("Preparing URL.");
		String url = baseURI + WeatherConstants.KEY_CITY + city+","+country+","+iso_code+ WeatherConstants.AMP + WeatherConstants.KEY_APP_ID + apiKey;
		logger.info("Prepared URL: "+url);
		return url;
	}
	
	/**
	 * Helper method to prepare URL Strings for Latitude and Longitude only
	 * @param city
	 * @return String URL
	 */
	private String prepareURLForLatLon(float lat, float lon) {
		logger.info("Preparing URL.");
		String url = baseURI + WeatherConstants.KEY_LATITUDE + lat+ WeatherConstants.AMP +WeatherConstants.KEY_LONGITUDE +lon + WeatherConstants.AMP + WeatherConstants.KEY_APP_ID + apiKey;
		logger.info("Prepared URL: "+url);
		return url;
	}
}
