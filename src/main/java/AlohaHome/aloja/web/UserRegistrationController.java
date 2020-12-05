package AlohaHome.aloja.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import AlohaHome.aloja.model.User;
import AlohaHome.aloja.service.UserService;
import AlohaHome.aloja.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;	
	}
   
    

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
    	
        return "registration";
    }
    /*
    @GetMapping
    public String showRegistrationForm(Model model) {
    	model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }*/
	
	
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto) {
    	userService.save(registrationDto);
    	return "redirect:/registration?success";
    }

	
}
