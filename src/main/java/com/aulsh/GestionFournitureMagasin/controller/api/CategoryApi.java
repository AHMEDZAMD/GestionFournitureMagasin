package com.aulsh.GestionFournitureMagasin.controller.api;



import com.aulsh.GestionFournitureMagasin.DTO.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aulsh.GestionFournitureMagasin.utils.Constants.APP_ROOT;

@Api(APP_ROOT+ "/categories")

public interface CategoryApi {

    @PostMapping(value =  APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister une category (Ajouter / Modifier)", notes = "cette methode pour enregistrer et modifier une categorie",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l'objet category cree / modifie"),
            @ApiResponse(    code = 400, message = "l'objet category nest pas valide")

    })

    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value =  APP_ROOT + "/categories/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une categorie ", notes = "cette methode permet de rechercher une Categorie  par son ID ",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "la categorie a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucune categorie trouver dans la BB avec ID fourni")

    })

    CategoryDto findById(@PathVariable("idCategory") Integer idCategory);


    @GetMapping (value =  APP_ROOT + "/categories/{codecategory}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une categorie ", notes = "cette methode permet de rechercher une categorie  par son CODE ",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l article a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucun article trouver dans la BB avec CODE fourni")
    })
    CategoryDto findBycodeCategory(@PathVariable("codecategory")String codecategory);



    @GetMapping (value =  APP_ROOT + "/categories/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des article  ", notes = "cette methode permet de rechercher et renvoyer la liste des categories  dans La BDD ",responseContainer ="List<CategoryDto>" )
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "La liste des categories / liste vide")})


    List<CategoryDto> findAll();



    @DeleteMapping(value =  APP_ROOT + "/categories/delete/{idCategory}")
    @ApiOperation(value = "supprimer un categorie ", notes = "cette methode permet de suprimer une categorie  par son ID ",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "la categorie a ete Supprimer ")

    })
    void delete(@PathVariable("idCategory")Integer idCategory);


}


