package com.java.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthController {
	@GetMapping(path="/basicauth")
	public AuthenticationBean basicAuth() {
		return new AuthenticationBean("You are authenticated.");
	}
}