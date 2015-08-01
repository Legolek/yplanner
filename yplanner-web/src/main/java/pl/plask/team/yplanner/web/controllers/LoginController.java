package pl.plask.team.yplanner.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/secured/*")
	public String data() {
		return "data";
	}
	
}
