package com.example.project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.Security.Config.JwtService;
import com.example.project.User.Role;
import com.example.project.User.User;
import com.example.project.User.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	AuthenticationManager authmanager;
	@Autowired
	UserRepository repository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtService jwtservice;

	public ResponseEntity<String> registerUser(Registerbody request) throws Exception {
		if(!repository.existsByEmail(request.getEmail())) {
			User user = new User();
	        user.setFirst_name(request.getFirstName());
	        user.setLast_name(request.getLastName());
	        user.setEmail(request.getEmail());
	        user.setPassword(encoder.encode(request.getPassword()));
	        user.setRole(request.getRole());
	        user.setAccountNonExpired(true);
	        user.setAccountNonLocked(true);
	        user.setEnabled(true);
			repository.save(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
		}
		 return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exits");
		
	}

	public ResponseEntity<?> authenticate_students(AuthRequestbody request) throws Exception {
			var user = repository.findByEmail(request.getEmail())
	                .orElseThrow();
			if(user.getRole() == Role.Students) {
				authmanager.authenticate(
	                	new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()
	                	)
					);
				var jwtToken = jwtservice.generateToken(user.getUsername());
				AuthReponsebody reponsebody = new AuthReponsebody();
				reponsebody.setEmail(user.getEmail());
				reponsebody.setToken(jwtToken);
				reponsebody.setExpiredata(jwtservice.extractExpiration(jwtToken));
				return ResponseEntity.status(HttpStatus.OK).body(reponsebody);
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not a student");
			}
		}

	public ResponseEntity<?> authenticate_facility(AuthRequestbody request) {
		var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
		if(user.getRole() == Role.Admin || user.getRole() == Role.Teacher) {
			authmanager.authenticate(
                	new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()
                	)
				);
			var jwtToken = jwtservice.generateToken(user.getUsername());
			AuthReponsebody reponsebody = new AuthReponsebody();
			reponsebody.setEmail(user.getEmail());
			reponsebody.setToken(jwtToken);
			reponsebody.setExpiredata(jwtservice.extractExpiration(jwtToken));
			return ResponseEntity.status(HttpStatus.OK).body(reponsebody);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not a facility");
		}
	}
	
}
