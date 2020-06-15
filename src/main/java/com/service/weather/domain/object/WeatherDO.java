/**
 * 
 */
package com.service.weather.domain.object;

import java.util.List;

import com.service.weather.domain.value.Clouds;
import com.service.weather.domain.value.Coordinates;
import com.service.weather.domain.value.Main;
import com.service.weather.domain.value.Weather;
import com.service.weather.domain.value.Wind;

/**
 * @author Simarpreet Singh, created on 10 April 2020
 *	Domain Object to store the Weather details, returned from API call.
 */
public class WeatherDO {
	
	private long id;
	private String name;
	private long timezone;
	private int cod;
	private long dt;
	private String visibility;
	private String base;
	
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private List<Weather> weather;
	private Coordinates coord;
	
	public WeatherDO() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTimezone() {
		return timezone;
	}

	public void setTimezone(long timezone) {
		this.timezone = timezone;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

}
