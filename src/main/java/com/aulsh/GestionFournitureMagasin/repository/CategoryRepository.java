package com.aulsh.GestionFournitureMagasin.repository;

import com.aulsh.GestionFournitureMagasin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findCategoryByCode(String codeCategory);

}
