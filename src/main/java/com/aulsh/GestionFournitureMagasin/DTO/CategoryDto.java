package com.aulsh.GestionFournitureMagasin.DTO;


import com.aulsh.GestionFournitureMagasin.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class CategoryDto {


    private  Integer Id;



    private String code;

    private String designation;



    public static CategoryDto FromEntity(Category category){

        if (category == null){

            // TODO throw an exception
            return  null;
        }

        return  CategoryDto.builder()
                .Id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();

    }


    public static Category ToEntity(CategoryDto categoryDto){
        if (categoryDto == null){

            // TODO throw an exception
            return  null;
        }




        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());

        return category;

    }
}
