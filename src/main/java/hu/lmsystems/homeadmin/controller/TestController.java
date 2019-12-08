package hu.lmsystems.homeadmin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/")
	public String getWelcomeMessage() {
		return "Spring boot is working!";	
	}
	
	@RequestMapping("/alter-message")
	public String getAlternateWelcomeMessage() {
		return "Spring boot is working well! Yes!!!";	
	}
}
