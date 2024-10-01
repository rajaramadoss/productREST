package net.codejava;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	

	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> list(){
		return service.listAll();
		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getID(@PathVariable Integer id) {
		try {
			Product product = service.getID(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products") // Insert Functions
	public void add(@RequestBody Product product) {
		service.save(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {

		try {
			Product existProduct = service.getID(id);
			System.out.println("existProduct :: ==>"+existProduct);
			System.out.println("Product :: ==>"+product);
			if(existProduct.getId()==id) {
				System.out.println("id :: ==>"+id);
				service.updateProduct(product);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteByID(id);
	}
}
