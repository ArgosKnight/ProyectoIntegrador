package AlohaHome.aloja.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import AlohaHome.aloja.model.User;
import AlohaHome.aloja.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	
	User save(UserRegistrationDto registrationDto);	
}
