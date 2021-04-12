package org.serratec.finalproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.finalproject.entity.Category;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@Autowired
	CategoryService service;

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return service.List();
	}

	@GetMapping("/categories/{id}")
	public Category searchId(@Valid @PathVariable Integer id) throws ResourceNotFoundException {
		return service.search(id);
	}

	@PostMapping("/categories")
	public Category insert(@Valid @RequestBody Category categories) {
		return service.create(categories);
	}

	@PutMapping("/categories/{id}")
	public Category edit(@PathVariable Integer id, @RequestBody Category categories) throws ResourceNotFoundException {
		return service.update(id, categories);
	}

	@DeleteMapping("/categories/{id}")
	public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException,NotAllowedException{
		service.delete(id);
	}

}
