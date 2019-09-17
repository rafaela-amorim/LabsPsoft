package subjects.entities;

import javax.persistence.Id;

public class Users {

	@Id
	private String email;
	private String nome;
	private String senha;
	
	public Users() {
		super();
	}
	
	public Users(String email, String nome, String senha) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public boolean verifyPasswd(String pass) {
		return pass.equals(senha);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
