package org.serratec.finalproject.repository;

import org.serratec.finalproject.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
