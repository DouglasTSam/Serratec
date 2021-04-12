package org.serratec.finalproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.finalproject.entity.Orders;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

	@Autowired
	OrdersService service;

	@GetMapping("/orders")
	public List<Orders> getOrders() {
		return service.List();
	}

	@GetMapping("/orders/{id}")
	public Orders searchId(@Valid @PathVariable Integer id) throws ResourceNotFoundException {
		return service.search(id);
	}

	@PostMapping("/orders")
	public Orders insert(@Valid @RequestBody Orders order) {
		return service.create(order);
	}

	@PutMapping("/orders/{id}")
	public Orders edit(@PathVariable Integer id, @RequestBody Orders order) throws ResourceNotFoundException {
		return service.update(id, order);
	}

	@DeleteMapping("/orders/{id}")
	public void deleteById(@PathVariable Integer id) throws ResourceNotFoundException,NotAllowedException {
		service.delete(id);
	}

}
