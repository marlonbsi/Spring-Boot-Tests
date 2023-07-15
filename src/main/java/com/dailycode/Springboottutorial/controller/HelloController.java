package com.dailycode.Springboottutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	@Value("${welcome.message}")
	private String welcomeMessage;
		
	@GetMapping("/")
	public String helloWorld() {
		return welcomeMessage;
	}

}
