package org.serratec.finalproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.finalproject.entity.Products;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

	@Autowired
	ProductsService service;

	@GetMapping("/products")
	public List<Products> getProducts() {
		return service.List();
	}

	@GetMapping("/products/{id}")
	public Products searchId(@Valid @PathVariable Integer id) throws ResourceNotFoundException {
		return service.search(id);
	}

	@PostMapping("/products")
	public Products insert(@Valid @RequestBody Products product) {
		return service.create(product);
	}

	@PutMapping("/products/{id}")
	public Products edit(@PathVariable Integer id, @RequestBody Products product) throws ResourceNotFoundException {
		return service.update(id, product);
	}

	@DeleteMapping("/products/{id}")
	public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException,NotAllowedException {
		service.delete(id);
	}

}
