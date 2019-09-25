package disciplinas.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import disciplinas.entities.Disciplina;
import disciplinas.services.DisciplinaService;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	public DisciplinaController(DisciplinaService DisciplinaService) {
		super();
		this.disciplinaService = DisciplinaService;		
	}
	
	
	@PostMapping("/disciplinas")
	public ResponseEntity<Disciplina> addSubject(@RequestBody Disciplina newSub) {
		return new ResponseEntity<Disciplina>(disciplinaService.addDisciplina(newSub), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/disciplinas")
	public ResponseEntity<List<Disciplina>> listAllDisciplina() {
		return new ResponseEntity<List<Disciplina>>(disciplinaService.listAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/disciplinas/{id}")
	public ResponseEntity<Disciplina> getById(@PathVariable Long id) {
		if (!disciplinaService.idExists(id) ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Disciplina>(disciplinaService.findSubject(id), HttpStatus.OK);
	}
	
	@PutMapping("/disciplinas/likes/{id}")
	public ResponseEntity<Disciplina> likeSubject(@PathVariable Long id) {
		if (!disciplinaService.idExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Disciplina>(disciplinaService.likeSubject(id), HttpStatus.OK);
	}
	
	@PutMapping("/disciplinas/nota/{id}")
	public ResponseEntity<Disciplina> attGrade(@PathVariable Long id, @RequestBody double newGrade) {
		if (!disciplinaService.idExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Disciplina>(disciplinaService.attGrade(id, newGrade), HttpStatus.OK);
	}
	
	@PostMapping("/disciplinas/comentarios/{id}")
	public ResponseEntity<Disciplina> postComment(@PathVariable Long id, @RequestBody String comment) {
		if (!disciplinaService.idExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Disciplina>(disciplinaService.postComment(id, comment), HttpStatus.OK);
	}
	
	@GetMapping("/disciplinas/ranking/notas")
	public ResponseEntity<List<Disciplina>> getGradesRanking() {
		return new ResponseEntity<List<Disciplina>>(disciplinaService.listSortedByGrade(), HttpStatus.OK);
	}
	
	@GetMapping("/disciplinas/ranking/likes")
	public ResponseEntity<List<Disciplina>> getLikesRanking() {
		return new ResponseEntity<List<Disciplina>>(disciplinaService.listSortedByLikes(), HttpStatus.OK);
	}
	
}












