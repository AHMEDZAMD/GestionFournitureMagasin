package com.aulsh.GestionFournitureMagasin.controller.api;

import com.aulsh.GestionFournitureMagasin.DTO.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.aulsh.GestionFournitureMagasin.utils.Constants.APP_ROOT;

@Api(APP_ROOT+ "/articles")
public interface ArticleApi {

    @PostMapping(value =  APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister un article (Ajouter / Modifier)", notes = "cette methode pour enregistrer et modifier un article",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l'objet article cree / modifie"),
            @ApiResponse(    code = 400, message = "l'objet article nest pas valide")

    })
    ArticleDto save(@RequestBody ArticleDto articleDto);





    @GetMapping (value =  APP_ROOT + "/articles/{Idarticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un article ", notes = "cette methode permet de rechercher un article  par son ID ",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l article a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucun article trouver dans la BB avec ID fourni")

    })
    ArticleDto findById(@PathVariable("Idarticle") Integer Idarticle);




    @GetMapping (value =  APP_ROOT + "/articles/{codearticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un article ", notes = "cette methode permet de rechercher un article  par son CODE ",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l article a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucun article trouver dans la BB avec CODE fourni")

    })
    ArticleDto findBycodeArticle(@PathVariable("codearticle") String codearticle);





    @GetMapping (value =  APP_ROOT + "/articles/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des article  ", notes = "cette methode permet de rechercher et renvoyer la liste des articles  dans La BDD ",responseContainer ="List<ArticleDto>" )
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "La liste des article / liste vide")})

    List<ArticleDto> findAll();




    @DeleteMapping(value =  APP_ROOT + "/articles/delete/{Idarticle}")
    @ApiOperation(value = "supprimer un article ", notes = "cette methode permet de suprimer un article  par son ID ",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l article a ete Supprimer ")

    })
    void delete(@PathVariable("Idarticle")Integer id);




}
