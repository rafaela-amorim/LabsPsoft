package disciplinas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import disciplinas.DAOs.DisciplinaRepository;
import disciplinas.entities.Disciplina;

@Service
public class DisciplinaService {
	
	private DisciplinaRepository<Disciplina, Long> disciplinasDAO;
	
	public DisciplinaService(DisciplinaRepository<Disciplina, Long> disciplinasDAO) {
		super();
		this.disciplinasDAO = disciplinasDAO;
	}
	
	// metodo para teste
	public Disciplina addDisciplina(Disciplina disciplina) {
		return disciplinasDAO.save(disciplina);
	}
	
	public List<Disciplina> listAll() {
		return disciplinasDAO.findAll();
	}
	
	public Optional<Disciplina> findObject(Long id) {
		return disciplinasDAO.findById(id);
	}
	
	
	
	public boolean idExists(Long id) {
		return disciplinasDAO.findById(id).isPresent();
	}
	
}
