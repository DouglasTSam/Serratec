package org.serratec.finalproject.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.serratec.finalproject.entity.Customers;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {

	@Autowired
	CustomersRepository repository;

	private List<Customers> customer = Arrays.asList();

	public List<Customers> List() {
		return repository.findAll();
	}

	public Customers create(Customers customer) {
		return repository.save(customer);
	}

	public Customers search(Integer id) throws ResourceNotFoundException {
		Optional<Customers> obj = repository.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		}
		throw new ResourceNotFoundException(id);
	}

	public Customers update(Integer id, Customers newObj) throws ResourceNotFoundException {
		Optional<Customers> inBd = repository.findById(id);

		if (inBd.isPresent()) {
			Customers newCustomers = inBd.get();
			newCustomers.setEmail(newObj.getEmail());
			newCustomers.setNameComplet(newObj.getNameComplet());
			newCustomers.setUserName(newObj.getUserName());
			newCustomers.setPassword(newObj.getPassword());
			return repository.save(newCustomers);
		}
		throw new ResourceNotFoundException(id);
	}

	public void delete(Integer id) throws ResourceNotFoundException,NotAllowedException {
		Optional<Customers> inBd = repository.findById(id);
		if (inBd.isPresent()) {
			try {
			repository.deleteById(id);
			}
			catch(Exception e) {
				throw new NotAllowedException(id); 
			}
		} else {
			throw new ResourceNotFoundException(id);
		}
	}
}