package com.service.weather.weatherrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.service.weather.controllers.WeatherController;
import com.service.weather.domain.object.WeatherDO;
import com.weather.exception.InvalidRequestParameterException;

@SpringBootTest
class WeatherRestApiApplicationTests {

	@Test
	void contextLoads() {
	}
	/**
	 * Testing Weather API, to get Weather details by City only.
	 * Valid output, with 200 status
	 */
	@Test
    public void testWeatherControllerCity() {
        WeatherController weatherController = new WeatherController();
        ResponseEntity<WeatherDO> result;
		try {
			result = weatherController.getWeatherForCity("dubai");
			assertEquals(result.getStatusCode(), 200);
		} catch (InvalidRequestParameterException e) {
			e.printStackTrace();
		}
        
    }
	
	/**
	 * Testing Weather API, to get Weather details by City,Country only.
	 * Valid output, with 200 status
	 */
	
	@Test
    public void testWeatherControllerCityCountry() {
        WeatherController weatherController = new WeatherController();
        ResponseEntity<WeatherDO> result;
		try {
			result = weatherController.getWeatherForCityInCountry("london","UK");
			assertEquals(result.getStatusCode(), 200);
		} catch (InvalidRequestParameterException e) {
			e.printStackTrace();
		}
        
    }
	
	/**
	 * Testing Weather API, to get Weather details by City,Country,ISO Code only.
	 * Produces error,404 city not found
	 */
	@Test
    public void testWeatherControllerCityCountryIso() {
        WeatherController weatherController = new WeatherController();
        ResponseEntity<WeatherDO> result;
		try {
			result = weatherController.getWeatherForCityInCountryCode("delhi","UAE","ARE");
			assertEquals(result.getStatusCode(), 404); //city not found
		} catch (InvalidRequestParameterException e) {
			e.printStackTrace();
		}
        
    }
	
	/**
	 * Testing Weather API, to get Weather details by Latitude and Longitude
	 * Valid output, with 200 status
	 */
	@Test
    public void testWeatherControllerLatLon() {
        WeatherController weatherController = new WeatherController();
        ResponseEntity<WeatherDO> result;
		result = weatherController.getWeatherForLatLon(35, 139);
		assertEquals(result.getStatusCode(), 200);
    }

}
