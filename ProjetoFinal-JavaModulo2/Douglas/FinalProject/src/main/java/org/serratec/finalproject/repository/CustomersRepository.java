package org.serratec.finalproject.repository;

import org.serratec.finalproject.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
