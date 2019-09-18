package subjects.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import subjects.entities.Subjects;
import subjects.services.SubjectsService;

@RequestMapping("v1/api/")
@RestController
public class SubjectsController {

	private SubjectsService subjectsService;
	
	public SubjectsController(SubjectsService subjectsService) {
		super();
		this.subjectsService = subjectsService;		
	}
	
	@PostMapping("disciplinas")
	public ResponseEntity<Subjects> addSubject(@RequestBody Subjects newSub) {
		return new ResponseEntity<Subjects>(subjectsService.addDisciplina(newSub), HttpStatus.CREATED);
	}
	
	/*
	@GetMapping("disciplinas")
	public ResponseEntity<List<Subjects>> listAllSubjects() {
		return new ResponseEntity<List<Subjects>>(subjectsService.listAll(), HttpStatus.OK);
	}
	*/
	
	/*
	@GetMapping("disciplinas/{id}")
	public ResponseEntity<Subjects> getById(@PathVariable Long id) {
		if (!subjectsService.idExists(id) ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Subjects>(subjectsService.findSubject(id), HttpStatus.OK);
	}
	*/
	
	/*
	@PutMapping("disciplinas/likes/{id}")
	public ResponseEntity<Subjects> likeSubject(@PathVariable Long id) {
		if (!subjectsService.idExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Subjects>(subjectsService.likeSubject(id), HttpStatus.OK);
	}
	*/
	
}