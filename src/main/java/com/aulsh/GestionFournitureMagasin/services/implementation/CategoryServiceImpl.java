package com.aulsh.GestionFournitureMagasin.services.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.CategoryDto;

import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.Category;
import com.aulsh.GestionFournitureMagasin.repository.CategoryRepository;
import com.aulsh.GestionFournitureMagasin.services.CategoryService;
import com.aulsh.GestionFournitureMagasin.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired  //injection par constructeur
    public CategoryServiceImpl(CategoryRepository categoryRepository){

        this.categoryRepository =categoryRepository;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);// la validation
        if (!errors.isEmpty()) {
            log.error("Category n'est pas valid {}", categoryDto);
            throw new InvalidEntityException("Category n'est pas valid", ErrorCodes.CATEGORY_NOT_VALID);
        }
        Category savedCategory = categoryRepository.save(CategoryDto.ToEntity(categoryDto));
        return CategoryDto.FromEntity(savedCategory);
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null){

            log.error("Category Id is null ");

            return null;
        }


        return categoryRepository.findById(id)
                .map(CategoryDto::FromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Category avec l ID = "+id+"n est pas trouver dans la BDD",
                                ErrorCodes.CATEGORY_NOT_FOUND));

    }

    @Override
    public CategoryDto findBycodeCategory(String codeCategory) {
        if (!StringUtils.hasLength(codeCategory)){

            log.error("Category CODE is Null");
            return null;
        }

        return categoryRepository.findCategoryByCode(codeCategory)
                .map(CategoryDto::FromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Category avec l CodeCategory = "+codeCategory+"n est pas trouver dans la BDD",
                                ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()  /// findAll predifine Function
                .map(CategoryDto::FromEntity)   /// faire le mapping d une Category a l autre avec methode refrence FromEntity
                .collect(Collectors.toList());  /// collecter et regreouper dans une list
    }

    @Override
    public void delete(Integer id) {
        if (id == null){

            log.error("Id of Category Is Null");

            return;
        }

        categoryRepository.deleteById(id);

    }
}
