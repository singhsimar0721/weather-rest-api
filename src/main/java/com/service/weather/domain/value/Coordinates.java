/**
 * 
 */
package com.service.weather.domain.value;

/**
 * @author Simarpreet Singh
 * Domain value object to store geo coordinates.
 *
 */
public class Coordinates {
	
	private float lon,lat;

	public Coordinates() {
		// TODO Auto-generated constructor stub
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}
	
	

}
