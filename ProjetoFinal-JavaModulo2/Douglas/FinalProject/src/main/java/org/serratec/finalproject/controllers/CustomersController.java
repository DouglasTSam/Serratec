package org.serratec.finalproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.finalproject.entity.Customers;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersController {

	@Autowired
	CustomersService service;

	@GetMapping("/customers")
	public List<Customers> getCustomer() {
		return service.List();
	}

	@GetMapping("/customers/{id}")
	public Customers searchId(@Valid @PathVariable Integer id) throws ResourceNotFoundException {
		return service.search(id);
	}

	@PostMapping("/customers")
	public Customers insert(@Valid @RequestBody Customers customer) {
		return service.create(customer);
	}

	@PutMapping("/customers/{id}")
	public Customers edit(@PathVariable Integer id, @RequestBody Customers customer) throws ResourceNotFoundException {
		return service.update(id, customer);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException,NotAllowedException {
		service.delete(id);
	}

}
