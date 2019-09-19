package disciplinas.DAOs;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disciplinas.entities.Users;

@Repository
public interface UsersRepository<T, ID extends Serializable> extends JpaRepository<Users, String> {

}
