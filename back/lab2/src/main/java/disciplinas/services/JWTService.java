package disciplinas.services;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import disciplinas.auxClasses.LoginResponse;
import disciplinas.entities.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public class JWTService {
	
	private final static String TOKEN_KEY = "login de RaFaeLia";
	
	private UsersService usersService;

	public JWTService(UsersService usersService) {
		super();
		this.usersService = usersService;
	}
	
//	-----------------------------

	public boolean usuarioExiste(String authorizationHeader) throws ServletException {
		String subjectEmail = getSujeitoDoToken(authorizationHeader);

		return usersService.userIsPresent(subjectEmail);
	}
	
	public boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
		String subjectEmail = getSujeitoDoToken(authorizationHeader);
		return usersService.userHasPermission(email, subjectEmail);
	}
	
	public LoginResponse authenticate(Users usuario) throws ServletException {	
		// verifica se o usuario existe no controller
		Users authUser = usersService.getUser(usuario.getEmail());
		
		if (authUser.checkPasswd(usuario.getSenha())) {
			String token = this.geraToken(authUser.getEmail());

			return new LoginResponse(token);
		} else {
			throw new ServletException("Senha invalida!");
		}
	}
	
	public String geraToken(String email) {
		return Jwts.builder().setSubject(email)
		.signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
		.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
		
		// 1 * 60 * 1000 é o tempo de duração do token (1 * 60 segundos)
	}
	
	public String getEmailByHeader(String authorizationHeader) throws ServletException {
		return getSujeitoDoToken(authorizationHeader);
	}
	
//	----------------------------

	// retorna o email (id) do usuario
	private String getSujeitoDoToken(String authorizationHeader) throws ServletException {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou mal formatado!");
		}

		// Extraindo apenas o token do cabecalho.
		String token = authorizationHeader.substring(disciplinas.filters.TokenFilter.TOKEN_INDEX);

		String subjectEmail = null;
		try {
			subjectEmail = Jwts.parser().setSigningKey(getTokenKey()).parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
			throw new ServletException("Token invalido ou expirado!");
		}
		
		return subjectEmail;
	}

	public static String getTokenKey() {
		return TOKEN_KEY;
	}
}
