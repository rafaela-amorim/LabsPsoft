package disciplinas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import disciplinas.entities.Disciplina;
import disciplinas.services.DisciplinaService;

@RequestMapping("v1/api/")
@RestController
public class DisciplinaController {

	private DisciplinaService disciplinaService;
	
	public DisciplinaController(DisciplinaService DisciplinaService) {
		super();
		this.disciplinaService = DisciplinaService;		
	}
	
	@PostMapping("disciplinas")
	public ResponseEntity<Disciplina> addSubject(@RequestBody Disciplina newSub) {
		return new ResponseEntity<Disciplina>(disciplinaService.addDisciplina(newSub), HttpStatus.CREATED);
	}
	
	/*
	@GetMapping("disciplinas")
	public ResponseEntity<List<Disciplina>> listAllDisciplina() {
		return new ResponseEntity<List<Disciplina>>(DisciplinaService.listAll(), HttpStatus.OK);
	}
	*/
	
	/*
	@GetMapping("disciplinas/{id}")
	public ResponseEntity<Disciplina> getById(@PathVariable Long id) {
		if (!DisciplinaService.idExists(id) ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Disciplina>(DisciplinaService.findSubject(id), HttpStatus.OK);
	}
	*/
	
	/*
	@PutMapping("disciplinas/likes/{id}")
	public ResponseEntity<Disciplina> likeSubject(@PathVariable Long id) {
		if (!DisciplinaService.idExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Disciplina>(DisciplinaService.likeSubject(id), HttpStatus.OK);
	}
	*/
	
}