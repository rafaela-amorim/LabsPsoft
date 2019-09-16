package comercio.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comercio.entities.Produto;
import comercio.services.ProdutoService;

@RestController
public class ProdutoController {

	private ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> addProduct(@RequestBody Produto produto) {
		return new ResponseEntity<Produto>(produtoService.addProduct(produto), HttpStatus.CREATED);
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> productById(@PathVariable Long id) {
		if (!produtoService.idExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Produto>(produtoService.productById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/produtos")
	public ResponseEntity<Collection<Produto>> getAllProducts

}









