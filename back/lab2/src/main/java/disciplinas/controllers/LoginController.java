package disciplinas.controllers;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import disciplinas.auxClasses.LoginResponse;
import disciplinas.entities.Users;
import disciplinas.services.JWTService;
import disciplinas.services.UsersService;

@RestController
public class LoginController {

	private UsersService userService;
	private JWTService jwtService;
	
	public LoginController(UsersService userService, JWTService jwtService) {
		super();
		this.userService = userService;
		this.jwtService = jwtService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody Users user) {
		if (!userService.userIsPresent(user.getEmail())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			
			try {
				LoginResponse token = jwtService.authenticate(user);
				return new ResponseEntity<LoginResponse>(token, HttpStatus.OK);
			} catch (ServletException e) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		}
	}
}
