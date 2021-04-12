package org.serratec.finalproject.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.serratec.finalproject.entity.Category;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;

	private List<Category> categories = Arrays.asList();

	public List<Category> List() {
		return repository.findAll();
	}

	public Category create(Category categories) {
		return repository.save(categories);
	}

	public Category search(Integer id) throws ResourceNotFoundException {
		Optional<Category> obj = repository.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		}
		throw new ResourceNotFoundException(id);
	}

	public Category update(Integer id, Category newObj) throws ResourceNotFoundException {
		Optional<Category> inBd = repository.findById(id);

		if (inBd.isPresent()) {
			Category newCategory = inBd.get();
			newCategory.setDescription(newObj.getDescription());
			newCategory.setName(newObj.getName());
			return repository.save(newCategory);
		}
		throw new ResourceNotFoundException(id);
	}

	public void delete(Integer id) throws ResourceNotFoundException,NotAllowedException {
		Optional<Category> inBd = repository.findById(id);
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