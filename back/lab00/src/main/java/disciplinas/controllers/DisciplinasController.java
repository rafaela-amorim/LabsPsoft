package disciplinas.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import disciplinas.entities.Disciplina;
import disciplinas.entities.DisciplinaDTO;
import disciplinas.services.DisciplinaService;

@RequestMapping("v1/api/")
@RestController
public class DisciplinasController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	
	@PostMapping("disciplinas")
	public ResponseEntity<Disciplina> addDisciplina(@RequestBody DisciplinaDTO d) {
		return new ResponseEntity<>(disciplinaService.addDisciplina(d.getNome(), d.getNota()), HttpStatus.OK);
	}
	
	@RequestMapping("disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplina(@PathVariable int id) {
		if (!idExists(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(disciplinaService.retornaDisciplina(id), HttpStatus.OK);
	}
	
	@RequestMapping("disciplinas")
	public ResponseEntity<Collection<Disciplina>> getCollectionDisciplina() {
		return new ResponseEntity<Collection<Disciplina>>((Collection<Disciplina>) disciplinaService.retornaTodasDisc(), HttpStatus.OK);
	}
	
	@DeleteMapping("disciplinas/{id}")
	public ResponseEntity<Disciplina> removeDisciplina(@PathVariable int id) {
		if (!idExists(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Disciplina>(disciplinaService.removeDisciplina(id), (HttpStatus.OK));
	}
	
	@PutMapping("disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> attName(@PathVariable int id, @RequestBody String newName) {
		if (!idExists(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Disciplina>(disciplinaService.atualizaNome(id, newName), HttpStatus.OK);
	}
	
	@PutMapping("disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> attNota(@PathVariable int id, @RequestBody double newNota) {
		if (!idExists(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Disciplina>(disciplinaService.atualizaNota(id, newNota), HttpStatus.OK);
	}
	
	@RequestMapping("disciplinas/ranking")
	public ResponseEntity<Collection<Disciplina>> allSubjectsByGrade() {
		return new ResponseEntity<Collection<Disciplina>>(disciplinaService.returnAllSubjectsByGrade(), HttpStatus.OK);
	}
	
	private boolean idExists(int id) {
		return disciplinaService.idExists(id);
	}
	 
}


















