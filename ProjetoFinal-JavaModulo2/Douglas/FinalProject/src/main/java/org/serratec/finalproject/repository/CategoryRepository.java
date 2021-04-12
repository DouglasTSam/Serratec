package org.serratec.finalproject.repository;

import org.serratec.finalproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
