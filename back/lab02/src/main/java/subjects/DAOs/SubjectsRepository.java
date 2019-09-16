package subjects.DAOs;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import subjects.entities.Subjects;

@Repository
public interface SubjectsRepository<T, ID extends Serializable> extends JpaRepository<Subjects, Long> {

}
