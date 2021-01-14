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
	public String propie() {
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
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contacto";
	}
	
	@RequestMapping("/perfil")
	public String perfil() {
		return "perfil";
	}
	
}
