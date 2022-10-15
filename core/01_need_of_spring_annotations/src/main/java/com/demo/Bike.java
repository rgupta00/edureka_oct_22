package com.demo;

import org.springframework.stereotype.Component;
//<bean id="v1" class="com.demo.Bike"/>

@Component
public class Bike implements Vehical{

	public void move() {
		System.out.println("moving on a bike...");
	}
}
