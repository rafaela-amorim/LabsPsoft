package disciplinas.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Disciplina extends DisciplinaDTO {
	
	private int id;
	
	@JsonCreator
	public Disciplina(int id, String nome, double nota) {
		super(nome, nota);
		this.id = id;
	}

	
	public int getId() {
		return id;
	}
	
}
