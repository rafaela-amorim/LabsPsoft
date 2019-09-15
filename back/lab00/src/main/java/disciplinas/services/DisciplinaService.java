package disciplinas.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonCreator;

import disciplinas.entities.Disciplina;

@Service
public class DisciplinaService {
	
	private HashMap<Integer, Disciplina> disciplinas;
	private int auxIdDisciplina;
	
	
	@JsonCreator
	public DisciplinaService() {
		disciplinas = new HashMap<>();
		auxIdDisciplina = 0;
	}
	
	
	public Disciplina addDisciplina(String nome, double nota) {
		Disciplina subject = new Disciplina(++auxIdDisciplina, nome, nota);
		disciplinas.put(auxIdDisciplina, subject);
		return subject;
	}

	public Disciplina retornaDisciplina(int id) {
		return disciplinas.get(id);
	}
	
	public Collection<Disciplina> retornaTodasDisc() {
		return disciplinas.values();
	}
	
	public Disciplina removeDisciplina(int id) {
		Disciplina d = disciplinas.remove(id);
		return d;
	}

	public Disciplina atualizaNome(int id, String nome) {
		disciplinas.get(id).setNome(nome);
		return disciplinas.get(id);
	}
	
	public Disciplina atualizaNota(int id, double nota) {
		disciplinas.get(id).setNota(nota);
		return disciplinas.get(id);
	}


	public boolean idExists(int id) {
		return disciplinas.containsKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Disciplina> returnAllSubjectsByGrade() {
		ArrayList<Disciplina> listaOrdenada = new ArrayList<Disciplina>(disciplinas.values());
		Collections.sort(listaOrdenada);
		return listaOrdenada;
	}
	
	
}
