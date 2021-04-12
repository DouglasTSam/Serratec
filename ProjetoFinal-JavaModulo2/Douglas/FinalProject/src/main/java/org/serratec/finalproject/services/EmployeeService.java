package org.serratec.finalproject.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.serratec.finalproject.entity.Employee;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	private List<Employee> employees = Arrays.asList();

	public List<Employee> List() {
		return repository.findAll();
	}

	public Employee create(Employee employees) {
		return repository.save(employees);
	}

	public Employee search(Integer id) throws ResourceNotFoundException {
		Optional<Employee> obj = repository.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		}
		throw new ResourceNotFoundException(id);
	}

	public Employee update(Integer id, Employee newObj) throws ResourceNotFoundException {
		Optional<Employee> inBd = repository.findById(id);

		if (inBd.isPresent()) {
			Employee newEmployee = inBd.get();
			newEmployee.setName(newObj.getName());
			newEmployee.setPassword(newObj.getPassword());
			return repository.save(newEmployee);
		}
		throw new ResourceNotFoundException(id);
	}

	public void delete(Integer id) throws ResourceNotFoundException,NotAllowedException {
		Optional<Employee> inBd = repository.findById(id);
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