package edu.taipp.SB_BMI.model;

public class InfoYourSelf {
	private float height;
	private float weight;
	public InfoYourSelf(float height, float weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
	public float getheight() {
		return height;
	}
	public void setheight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
