package disciplinas.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Disciplina {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private double nota;
	private ArrayList<String> comments; 
	private int likes;
	
	public Disciplina() {
		super();
		this.comments = new ArrayList<>();
	}
	
	public Disciplina(long id, String nome, double nota, ArrayList<String> comments,int likes) {
		super();
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

	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
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
	
	public void setId(long id) {
		this.id = id;
	}
	
}
