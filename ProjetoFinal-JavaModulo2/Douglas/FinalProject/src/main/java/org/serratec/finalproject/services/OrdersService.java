package org.serratec.finalproject.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.serratec.finalproject.entity.Orders;
import org.serratec.finalproject.exceptions.NotAllowedException;
import org.serratec.finalproject.exceptions.ResourceNotFoundException;
import org.serratec.finalproject.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository repository;

	private List<Orders> order = Arrays.asList();

	public List<Orders> List() {
		return repository.findAll();
	}

	public Orders create(Orders order) {
		return repository.save(order);
	}

	public Orders search(Integer id) throws ResourceNotFoundException {
		Optional<Orders> obj = repository.findById(id);
		
		if(obj.isPresent()) {
			return obj.get();
		}
		throw new ResourceNotFoundException(id);
	}

	public Orders update(Integer id, Orders newObj) throws ResourceNotFoundException {
		Optional<Orders> inBd = repository.findById(id);

		if (inBd.isPresent()) {
			Orders newOrders = inBd.get();
			newOrders.setDateOrder(newObj.getDateOrder());
			//newOrders.setName(newObj.getName());
			return repository.save(newOrders);
		}
		throw new ResourceNotFoundException(id);
	}

	public void delete(Integer id) throws ResourceNotFoundException,NotAllowedException {
		Optional<Orders> inBd = repository.findById(id);
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