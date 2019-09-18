package subjects.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import subjects.services.CommentsService;

@Entity
public class Subjects {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private double nota;
	private CommentsService commentsService; 
	private int likes;
	
	public Subjects() {
		super();
	}
	
	public Subjects(long id, String nome, double nota, CommentsService commentsService, int likes) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
		this.commentsService = commentsService;
		this.likes = likes;
	}
	
//	----------------------------
	
	public Comments postComment(Comments comment) {
		return commentsService.addComment(comment);
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
