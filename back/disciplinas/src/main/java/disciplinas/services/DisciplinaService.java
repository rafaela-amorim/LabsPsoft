package disciplinas.services;

import java.util.Collections;
import java.util.List;

import comparators.GradesComparator;
import comparators.LikesComparator;
import disciplinas.DAOs.DisciplinaRepository;
import disciplinas.entities.Disciplina;


public class DisciplinaService {
	
    private DisciplinaRepository<Disciplina, Long> disciplinasDAO;

    public DisciplinaService(DisciplinaRepository<Disciplina, Long> disciplinasDAO) {
    	super();
    	this.disciplinasDAO = disciplinasDAO;
    }

    //------------------------------------

    // metodo para teste
    public Disciplina addDisciplina(Disciplina Disciplina) {
    	return disciplinasDAO.save(Disciplina);
    }

    public List<Disciplina> listAll() {
    	return disciplinasDAO.findAll();
    }

    public Disciplina findSubject(Long id) {
    	return disciplinasDAO.findById(id).get();
    }

    public Disciplina likeSubject(Long id) {
    	disciplinasDAO.findById(id).get().likesSubject();
    	return disciplinasDAO.findById(id).get();
    }

    public Disciplina attGrade(Long id, double newGrade) {
    	disciplinasDAO.findById(id).get().setNota(newGrade);
    	return disciplinasDAO.findById(id).get();
    }

    public Disciplina postComment(Long id, String comment) {
    	disciplinasDAO.findById(id).get().postComment(comment);
    	return disciplinasDAO.findById(id).get();
    }

    public List<Disciplina> listSortedByGrade() {
    	List<Disciplina> lista = disciplinasDAO.findAll();
    	GradesComparator gc = new GradesComparator();
    	Collections.sort(lista, gc);
    
    	return lista;
    }

    public List<Disciplina> listSortedByLikes() {
    	List<Disciplina> lista = disciplinasDAO.findAll();
    	LikesComparator lc = new LikesComparator();
    	Collections.sort(lista, lc);
    
    	return lista;
    }

    //-------------

    public boolean idExists(Long id) {
    	return disciplinasDAO.findById(id).isPresent();
    }

}