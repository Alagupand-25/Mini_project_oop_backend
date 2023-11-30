package com.example.project.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;


@RestController 
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController{
	
	@Autowired
	JwtService jwtservice;
	@Autowired
	AuthService authservice;
	
	@GetMapping
	public String getdata() {
		return "hi";
	}
	
	@GetMapping("check_generateToken")
	public String gettoken() {
		return jwtservice.generateToken("admin@gmail.com");
	}
	
	@GetMapping("/token_check")
	private Object calmier() {
		return jwtservice.extractUsername(gettoken());
	}
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Registerbody registerbody){
		
		try {
			return authservice.registerUser(registerbody);
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
    }
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthReponsebody> register(@RequestBody AuthRequestbody request
	    ){
	        return ResponseEntity.status(HttpStatus.OK).body(authservice.authenticate(request));

	 }
}