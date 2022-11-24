package com.abm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	
	@RequestMapping("/helloAgain")
	public String sayHello(@RequestParam("name") String name) {
		return "Hello "+ name + ", Welcome to Restful Spring MVC";
	} 
}
