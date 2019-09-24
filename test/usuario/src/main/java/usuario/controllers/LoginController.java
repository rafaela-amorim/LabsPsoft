package usuario.controllers;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import usuario.entities.LoginResponse;
import usuario.entities.Usuario;
import usuario.services.JWTService;
import usuario.services.UsuariosService;

@RestController
public class LoginController {
	
	private UsuariosService usuarioService;
	private JWTService jwtService;
	
	public LoginController(UsuariosService usuarioService, JWTService jwtService) {
		super();
		this.usuarioService = usuarioService;
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody Usuario usuario) throws ServletException {
		if (jwtService.verificaSenha(usuario, usuarioService.getUser(usuario.getEmail()).get() ) ) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<LoginResponse>(jwtService.authenticate(usuario), HttpStatus.OK);
	}
	
}
