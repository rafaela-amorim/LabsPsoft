package comercio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comercio.DAOs.ProdutoDAO;
import comercio.entities.Produto;

@Service
public class ProdutoService {

	private ProdutoDAO<Produto, Long> produtosDAO;
	
	public ProdutoService(ProdutoDAO<Produto, Long> produtosDAO) {
		super();
		this.produtosDAO = produtosDAO;
	}	
	
	public Produto addProduct(Produto produto) {
		return produtosDAO.save(produto);
	}
	
	public List<Produto> listAllProducts() {
		return produtosDAO.findAll();
	}
	
	public Optional<Produto> productById(Long id) {
		return produtosDAO.findById(id);
	}
	
	public boolean idExists(Long id) {
		return produtosDAO.findById(id).isPresent();
	}
}
