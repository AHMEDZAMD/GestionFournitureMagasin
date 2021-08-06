package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.CategoryDto;

import java.util.List;

public interface CategoryService {


    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(Integer id);
    CategoryDto findBycodeCategory(String codecategory);

    List<CategoryDto> findAll();
    void delete(Integer id);
}
