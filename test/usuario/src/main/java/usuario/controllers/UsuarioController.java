package usuario.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import usuario.entities.Usuario;
import usuario.services.UsuariosService;

@RestController
public class UsuarioController {

	private UsuariosService usuarioService;
	
	public UsuarioController(UsuariosService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> addUser(Usuario user) {
		return new ResponseEntity<Usuario>(usuarioService.addUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/usuarios/{email}")
	public ResponseEntity<Usuario> getUser(@PathVariable String email) {
		if (!usuarioService.idExists(email) ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuarioService.getUser(email).get(), HttpStatus.OK);
	}
	
	
	
	
}
