package AlohaHome.aloja.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerBasic {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/property")
	public String contact() {
		return "property-grid";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
}
