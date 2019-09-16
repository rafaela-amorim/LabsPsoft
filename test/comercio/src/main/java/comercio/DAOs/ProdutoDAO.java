package comercio.DAOs;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comercio.entities.Produto;

@Repository
public interface ProdutoDAO<T, ID extends Serializable> extends JpaRepository<Produto, Long> {

}
