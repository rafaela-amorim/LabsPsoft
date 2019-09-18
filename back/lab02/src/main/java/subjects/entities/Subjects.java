package subjects.entities;

import java.util.ArrayList;
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
	private List<String> comments; 
	private int likes;
	
	public Subjects() {
		super();
	}
	
	public Subjects(long id, String nome, double nota, ArrayList<String> comments, int likes) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
		this.comments = comments;
		this.likes = likes;
	}
	
//	----------------------------
	
	public void postComment(String comment) {
		this.comments.add(comment);
	}
	
	
	public void likesSubject() {
		this.likes++;
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public long getId() {
		return id;
	}
	
}
