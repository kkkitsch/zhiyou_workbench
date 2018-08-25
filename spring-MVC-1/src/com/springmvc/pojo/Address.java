package com.springmvc.pojo;

public class Address {

	private String city;
	private String street;

	public Address() {
		super();
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}

}
