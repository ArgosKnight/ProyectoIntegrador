package AlohaHome.aloja.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import AlohaHome.aloja.model.Role;
import AlohaHome.aloja.model.User;
import AlohaHome.aloja.repository.UserRepository;
import AlohaHome.aloja.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
    	super();
    	this.userRepository=userRepository;
    }
    public User save(UserRegistrationDto registrationDto) {
    	/*
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));*/
    	
    	User user = new User(registrationDto.getFirstName(),
    			registrationDto.getLastName(),registrationDto.getEmail(),
    			passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
    
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    }
    
	
}