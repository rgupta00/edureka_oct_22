package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component(value = "p")	//<bean id="p" class="com.demo.Passanger" 
public class Passanger {
	@Value(value = "raja")
	private String name;	//<property name="name" value="raja"/>
	
	private Vehical vehical;	//autowire="byType">

	public void setName(String name) {
		this.name = name;
	}

	@Autowired
	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}

	public void travel() {
		System.out.println("passanger name: " + name);
		vehical.move();
	}
}
