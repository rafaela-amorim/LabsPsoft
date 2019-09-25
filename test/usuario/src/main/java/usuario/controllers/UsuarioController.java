package usuario.controllers;

import javax.servlet.ServletException;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import usuario.entities.Usuario;
import usuario.services.JWTService;
import usuario.services.UsuariosService;

@RestController
public class UsuarioController {

	private UsuariosService usuarioService;
	private JWTService jwtService;
	
	public UsuarioController(UsuariosService usuarioService, JWTService jwtService) {
		super();
		this.usuarioService = usuarioService;
		this.jwtService = jwtService;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> addUser(@RequestBody Usuario user) {
		return new ResponseEntity<Usuario>(usuarioService.addUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/usuarios/{email}")
	public ResponseEntity<Usuario> getUser(@PathVariable String email) {
		if (!usuarioService.idExists(email) ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuarioService.getUser(email).get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/auth/usuarios/{email}")
	public ResponseEntity<Usuario> removeUser(@PathVariable String email, @RequestHeader("Authorization") String header) {
		if (!usuarioService.idExists(email)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			if (jwtService.usuarioTemPermissao(header, email)) {
				return new ResponseEntity<Usuario>(usuarioService.removeUser(email), HttpStatus.OK);
			}
		} catch (ServletException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);		
	}
	
	
	
	
}
