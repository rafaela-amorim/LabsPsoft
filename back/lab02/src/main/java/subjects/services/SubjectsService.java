package subjects.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comparators.GradesComparator;
import comparators.LikesComparator;
import subjects.DAOs.SubjectsRepository;
import subjects.entities.Subjects;

@Service
public class SubjectsService {
	
	private SubjectsRepository<Subjects, Long> disciplinasDAO;
	
	public SubjectsService(SubjectsRepository<Subjects, Long> disciplinasDAO) {
		super();
		this.disciplinasDAO = disciplinasDAO;
	}
	
	// metodo para teste
	public Subjects addDisciplina(Subjects subjects) {
		return disciplinasDAO.save(subjects);
	}
	
	public List<Subjects> listAll() {
		return disciplinasDAO.findAll();
	}
	
	public Subjects findSubject(Long id) {
		return disciplinasDAO.findById(id).get();
	}

	public Subjects likeSubject(Long id) {
		disciplinasDAO.findById(id).get().likesSubject();
		return disciplinasDAO.findById(id).get();
	}
	
	public Subjects attGrade(Long id, double newGrade) {
		disciplinasDAO.findById(id).get().setNota(newGrade);
		return disciplinasDAO.findById(id).get();
	}
	
	public Subjects postComment(Long id, String comment) {
		disciplinasDAO.findById(id).get().postComment(comment);
		return disciplinasDAO.findById(id).get();
	}
	
	public List<Subjects> listSortedByGrade() {
		List<Subjects> lista = disciplinasDAO.findAll();
		GradesComparator gc = new GradesComparator();
		Collections.sort(lista, gc);
		
		return lista;
	}
	
	public List<Subjects> listSortedByLikes() {
		List<Subjects> lista = disciplinasDAO.findAll();
		LikesComparator lc = new LikesComparator();
		Collections.sort(lista, lc);
		
		return lista;
	}
	
	
//	-------------
	
	public boolean idExists(Long id) {
		return disciplinasDAO.findById(id).isPresent();
	}
	
}












