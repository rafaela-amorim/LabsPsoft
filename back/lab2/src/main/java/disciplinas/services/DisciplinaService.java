package disciplinas.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import comparators.GradesComparator;
import comparators.LikesComparator;
import disciplinas.DAOs.DisciplinaRepository;
import disciplinas.entities.Disciplina;

@Service
public class DisciplinaService {
	
    private DisciplinaRepository<Disciplina, Long> disciplinasDAO;

    public DisciplinaService(DisciplinaRepository<Disciplina, Long> disciplinasDAO) {
    	super();
    	this.disciplinasDAO = disciplinasDAO;
    }

    //------------------------------------
    	
    @PostConstruct
    public void initDisciplinas() {
    	if (disciplinasDAO.count() == 0) {
    		ObjectMapper mapper = new ObjectMapper();
        	TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {};
        	InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplinas.json");
        	
        	try {
        		List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
        		disciplinasDAO.saveAll(disciplinas);
        		System.out.println("Alunos salvos no BD!!");
        	} catch (IOException e) {
        		System.out.println("Não foi possivel salvar as disciplinas: " + e.getMessage());
        	}
    	}
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
    	Disciplina d = disciplinasDAO.findById(id).get();
    	d.likesSubject();
    	disciplinasDAO.save(d);
    	return d;
    }
	
	
    public Disciplina attGrade(Long id, double newGrade) {
    	Disciplina d = disciplinasDAO.findById(id).get();
    	d.setNota(newGrade);
    	disciplinasDAO.save(d);
    	return d;
    }
   
    public Disciplina postComment(Long id, String comment) {
    	Disciplina d = disciplinasDAO.findById(id).get();
    	d.postComment(comment);
    	disciplinasDAO.save(d);
    	return d;
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