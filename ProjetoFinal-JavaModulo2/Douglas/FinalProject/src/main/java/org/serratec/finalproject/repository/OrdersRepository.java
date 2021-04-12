package org.serratec.finalproject.repository;

import org.serratec.finalproject.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
