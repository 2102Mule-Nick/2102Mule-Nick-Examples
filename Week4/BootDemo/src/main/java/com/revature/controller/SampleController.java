package com.revature.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/hello")
	public String sayHello(@RequestParam String name) {
		return "Hello " + name;
	}
	
}
