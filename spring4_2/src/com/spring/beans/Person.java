package com.spring.beans;

import java.util.List;
import java.util.Map;

public class Person {

	private String name;
	private int age;
	private List<Car> cars;
	private List<String> info;
	private Map<String, Car> maps;

	public Person() {
	}

	public Person(String name, int age, List<Car> cars) {
		this.name = name;
		this.age = age;
		this.cars = cars;
	}

	public int getAge() {
		return age;
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getInfo() {
		return info;
	}

	public Map<String, Car> getMaps() {
		return maps;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void setInfo(List<String> info) {
		this.info = info;
	}

	public void setMaps(Map<String, Car> maps) {
		this.maps = maps;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", cars=" + cars + ", info=" + info + ", maps=" + maps + "]";
	}
}
