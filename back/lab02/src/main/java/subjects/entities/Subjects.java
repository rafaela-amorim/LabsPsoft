package subjects.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subjects {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private double nota;
	private List<String> comentarios;
	private int likes;
	
	public Subjects() {
		super();
	}
	
	public Subjects(long id, String nome, double nota, List<String> comentarios, int likes) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
		this.comentarios = comentarios;
		this.likes = likes;
	}
	
//	----------------------------
	
	public void postComment(String comment) {
		comentarios.add(comment);
	}
	
//	----------------------------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public List<String> getComentarios() {
		return comentarios;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public long getId() {
		return id;
	}
	
	public void likesSubject() {
		this.likes++;
	}
	
}
