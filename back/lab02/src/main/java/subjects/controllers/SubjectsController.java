package subjects.controllers;

import org.springframework.web.bind.annotation.RestController;

import subjects.services.SubjectsService;

@RestController
public class SubjectsController {

	private SubjectsService subjectsService;
	
	public SubjectsController(SubjectsService subjectsService) {
		super();
		this.subjectsService = subjectsService;		
	}
	
//	@Get
	
}
