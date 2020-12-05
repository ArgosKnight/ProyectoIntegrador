package AlohaHome.aloja.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	
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
	@RequestMapping("/registration")
	public String register() {
		return "registration";
	}

}
