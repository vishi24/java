package com.vishwa.rest.model;

import org.springframework.stereotype.Component;

@Component
public class user {
	private String name="";
	private String age="";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	

}
