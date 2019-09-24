package usuario.services;

import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import usuario.entities.LoginResponse;
import usuario.entities.Usuario;

@Service
public class JWTService {
	
	private final String TOKEN_KEY = "login do batman";
	
	private UsuariosService usuariosService;
	
	public JWTService(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}
	
//	--------------------------
	
	public LoginResponse authenticate(Usuario user) throws ServletException {
		// Recupera o usuario
		Optional<Usuario> authUsuario = usuariosService.getUser(user.getEmail());

		// verificacoes
		if (authUsuario.isEmpty()) {
			throw new ServletException("Usuario nao encontrado!");
		}

		// verifica se a senha do usuario passado no param é igual a senha do
		// usuario armazenado no banco de dados
		
		String token = this.geraToken(authUsuario.get().getEmail());

		return new LoginResponse(token);

	}
	
	private String geraToken(String email) {
		return Jwts.builder().setSubject(email)
		.signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
		.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
	}

	public boolean usuarioExiste(String authorizationHeader) throws ServletException {
		String subject = getSujeitoDoToken(authorizationHeader);

		return usuariosService.getUser(subject).isPresent();
	}
	
	public boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
		String subject = getSujeitoDoToken(authorizationHeader);

		Optional<Usuario> optUsuario = usuariosService.getUser(subject);
		return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
	}

	private String getSujeitoDoToken(String authorizationHeader) throws ServletException {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou mal formatado!");
		}

		// Extraindo apenas o token do cabecalho.
		String token = authorizationHeader.substring(usuario.filters.TokenFilter.TOKEN_INDEX);

		String subject = null;
		try {
			subject = Jwts.parser().setSigningKey("login do batman").parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
			throw new ServletException("Token invalido ou expirado!");
		}
		return subject;
	}

//	------------------------------
	
	public boolean verificaSenha(Usuario u1, Usuario u2) {
		return u1.getSenha().equals(u2.getSenha());
	}
	
	public String getTokenKey() {
		return TOKEN_KEY;
	}
	
}
