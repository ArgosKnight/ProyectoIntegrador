package AlohaHome.alojacontroller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller

public class ControllerBasic {

	@RequestMapping("/")
	public String saludar() {
		return "index";
	}
	
	
}
