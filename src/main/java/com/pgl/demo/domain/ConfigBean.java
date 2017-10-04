package com.pgl.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="zhuy")
public class ConfigBean {
	private String name;
	private int age;
	private int number;
	private String uuid;
	private int  max;
	private String value;
	private String greeting;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	@Override
	public String toString() {
		return "ConfigBean [name=" + name + ", age=" + age + ", number=" + number + ", uuid=" + uuid + ", max=" + max
				+ ", value=" + value + ", greeting=" + greeting + "]";
	}
	

}
