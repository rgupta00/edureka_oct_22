package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//<bean id="v2" class="com.demo.Car" primary="true"/>
@Component
@Primary
public class Car implements Vehical{

	public void move() {
		System.out.println("moving in car...");
	}
}
