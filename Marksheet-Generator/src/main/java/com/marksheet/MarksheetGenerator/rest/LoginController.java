package com.marksheet.MarksheetGenerator.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("/login")
	public String showMyLoginPage() {
		
		return "login";
		
	}

}
