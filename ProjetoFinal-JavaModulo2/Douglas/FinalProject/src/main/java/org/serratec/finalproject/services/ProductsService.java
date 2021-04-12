package org.serratec.finalproject.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.serratec.finalproject.entity.Products;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

	@Autowired
	ProductsRepository repository;

	private List<Products> product = Arrays.asList();

	public List<Products> List() {
		return repository.findAll();
	}

	public Products create(Products product) {
		return repository.save(product);
	}

	public Products search(Integer id) throws ResourceNotFoundException {
		Optional<Products> obj = repository.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		}
		throw new ResourceNotFoundException(id);
	}

	public Products update(Integer id, Products newObj) throws ResourceNotFoundException {
		Optional<Products> inBd = repository.findById(id);

		if (inBd.isPresent()) {
			Products newProducts = inBd.get();
			newProducts.setDescription(newObj.getDescription());
			newProducts.setName(newObj.getName());
			return repository.save(newProducts);
		}
		throw new ResourceNotFoundException(id);
	}

	public void delete(Integer id) throws ResourceNotFoundException,NotAllowedException {
		Optional<Products> inBd = repository.findById(id);
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