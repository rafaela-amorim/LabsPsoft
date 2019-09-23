package usuario.services;

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
	
	public Usuario getUser(String email) {
		return usuarioRepository.findById(email).get();
	}
	
}
