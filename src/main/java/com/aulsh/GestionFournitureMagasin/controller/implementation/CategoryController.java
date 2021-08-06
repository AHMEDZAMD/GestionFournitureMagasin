package com.aulsh.GestionFournitureMagasin.controller.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.CategoryDto;
import com.aulsh.GestionFournitureMagasin.controller.api.CategoryApi;
import com.aulsh.GestionFournitureMagasin.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;

    @Autowired
 public CategoryController (CategoryService categoryService){

        this.categoryService  = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer idCategory) {
        return categoryService.findById(idCategory);
    }

    @Override
    public CategoryDto findBycodeCategory(String codecategory) {
        return categoryService.findBycodeCategory(codecategory);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer idCategory) {
        categoryService.delete(idCategory);

    }
}
