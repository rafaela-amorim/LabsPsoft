package disciplinas.DAOs;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import disciplinas.entities.Disciplina;

public interface DisciplinaRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Long>{

}

