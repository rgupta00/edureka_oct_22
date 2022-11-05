package com.bankapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

	@GetMapping(path = "hello/{name}")
	public String hello(@PathVariable(name = "name")  String name) {
		return "hello "+ name +" you are going in right direction!";
	}
}
