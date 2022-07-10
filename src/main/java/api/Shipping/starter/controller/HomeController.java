package api.Shipping.starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String printHome() {
		return "<h1>Hello</h1>";
	}
	
}
