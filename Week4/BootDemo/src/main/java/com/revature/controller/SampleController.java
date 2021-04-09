package com.revature.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SampleController {

	@Operation(description = "this is used to get a greeting message from the server")
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "everything is ok when getting the message",
				content = @Content(
						schema = @Schema(implementation = String.class)
						)
				),
		@ApiResponse(
				responseCode = "400",
				description = "you did something wrong",
				content = @Content
				)
	})
	@GetMapping("/hello")
	public String sayHello(@RequestParam String name) {
		return "Hello " + name;
	}
	
	@PostMapping("/hello")
	public String sayHelloPost(@RequestBody String name) {
		return "Saying hello to " + name + " from a post request.";
	}
	
}
