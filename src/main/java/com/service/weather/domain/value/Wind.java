package com.service.weather.domain.value;

/**
 * @author Simarpreet Singh
 *	Domain Value to store wind related information only.
 */
public class Wind {

	private float speed;
	private int deg;
	
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public int getDeg() {
		return deg;
	}
	public void setDeg(int deg) {
		this.deg = deg;
	}
	
	
}
