package disciplinas.DAOs;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disciplinas.entities.Disciplina;

@Repository
public interface DisciplinaRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Long> {

}
