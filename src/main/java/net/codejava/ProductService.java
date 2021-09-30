package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	
	public List<Product> listAll(){
		
		return repo.findAll();
	}
	
	public void save(Product product) {
		repo.save(product);
		
	}
	public Product getID(Integer id) {
		return repo.findById(id).get();
	}
	public void deleteByID(Integer id) {
		  repo.deleteById(id);
	}
}
