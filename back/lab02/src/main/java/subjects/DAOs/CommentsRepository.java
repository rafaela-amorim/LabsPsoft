package subjects.DAOs;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import subjects.entities.Comments;

@Repository
public interface CommentsRepository<T, ID extends Serializable> extends JpaRepository<Comments, Long> {

}
