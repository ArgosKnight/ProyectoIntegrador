package AlohaHome.alojacontroller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aveces")
public class ControllerBasic {

	@GetMapping(path = {"/saludar","/hola"})
	public String index() {
		return "index";
	}
	@GetMapping(path = {"/contact","/contacto"})
	public String contact() {
		return "contact";
	}
}
