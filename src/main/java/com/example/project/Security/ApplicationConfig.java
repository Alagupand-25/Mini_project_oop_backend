package com.example.project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.project.User.UserRepository;


@Configuration
public class ApplicationConfig {
	
	@Autowired
	UserRepository userepo;
	
    @Bean
    public UserDetailsService userDetailsService() {
	    return username -> userepo.findByEmail(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
	  }
}
