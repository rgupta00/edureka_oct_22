package com.demo;

public class Main {

	public static void main(String[] args) {
		
		//this was a pull model ie passanger is pulling the dep
		Vehical vehical=new Car();
		
		Passanger passanger=new Passanger();
		
		passanger.setName("ravi");
		passanger.setVehical(vehical);
		
		passanger.travel();
	}
}
