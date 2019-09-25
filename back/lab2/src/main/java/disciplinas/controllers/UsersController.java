package disciplinas.controllers;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import disciplinas.entities.Users;
import disciplinas.services.JWTService;
import disciplinas.services.UsersService;

@RestController
public class UsersController {

	private UsersService usersService;
	private JWTService jwtService;
	
	public UsersController(UsersService usersService, JWTService jwtService) {
		super();
		this.usersService = usersService;
		this.jwtService = jwtService;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		return new ResponseEntity<Users>(usersService.addUser(user), HttpStatus.CREATED);
	}
	
	// somente para testes
	@GetMapping("/usuarios/{email}")
	public ResponseEntity<Users> getUser(@PathVariable String email) {
		if (!usersService.userIsPresent(email)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Users>(usersService.getUser(email), HttpStatus.OK);
	}
	
	@DeleteMapping("/auth/usuarios")
	public ResponseEntity<Users> removeUser(@RequestHeader("Authorization") String header) {
		try {
			String email = jwtService.getEmailByHeader(header);
			
			if (jwtService.usuarioTemPermissao(header, email)) {
				return new ResponseEntity<Users>(usersService.removeUser(email), HttpStatus.OK);
			} 
			
		} catch (ServletException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
}
