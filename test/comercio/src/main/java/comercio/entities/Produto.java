package comercio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String descricao;
	private double preco;
	
	
	public Produto() {
		super();
	}
	
	public Produto(long id, String nome, String descricao, double preco) {
		this.id = id;
		this.descricao = descricao;
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getId() {
		return id;
	}
	
	
	
	
}
