/**
 * 
 */
package com.service.weather.domain.value;

/**
 * @author Simarpreet Singh
 *	Domain Value to store Sunrise, Sunset related information only.
 */
public class SysDetails {

	private int type;
	private int id;
	private String country;
	private long sunrise,sunset;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getSunrise() {
		return sunrise;
	}
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}
	public long getSunset() {
		return sunset;
	}
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
	
	
}
