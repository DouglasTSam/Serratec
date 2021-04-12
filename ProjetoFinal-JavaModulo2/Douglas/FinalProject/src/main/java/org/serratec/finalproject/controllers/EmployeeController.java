package org.serratec.finalproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.finalproject.entity.Employee;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/employees")
	public List<Employee> getemployees() {
		return service.List();
	}

	@GetMapping("/employees/{id}")
	public Employee searchId(@Valid @PathVariable Integer id) throws ResourceNotFoundException {
		return service.search(id);
	}

	@PostMapping("/employees")
	public Employee insert(@Valid @RequestBody Employee employees) {
		return service.create(employees);
	}

	@PutMapping("/employees/{id}")
	public Employee edit(@PathVariable Integer id, @RequestBody Employee employees) throws ResourceNotFoundException {
		return service.update(id, employees);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException,NotAllowedException {
		service.delete(id);
	}

}
