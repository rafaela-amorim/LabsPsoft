package usuario.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import usuario.entities.Usuario;
import usuario.repositories.UsuarioRepository;

@Service
public class UsuariosService {

	private UsuarioRepository<Usuario, String> usuarioRepository;
	
	public UsuariosService(UsuarioRepository<Usuario, String> usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
//	------------------------------
	
	public Usuario addUser(Usuario user) {
		return usuarioRepository.save(user);
	}
	
	public Optional<Usuario> getUser(String email) {
		return usuarioRepository.findById(email);
	}
	
	public boolean idExists(String email) {
		return usuarioRepository.findById(email).isPresent();
	}	
	
	public Usuario removeUser(String email) {
		Usuario user = usuarioRepository.findById(email).get();
		usuarioRepository.deleteById(email);
		return user;
	}
	
}
