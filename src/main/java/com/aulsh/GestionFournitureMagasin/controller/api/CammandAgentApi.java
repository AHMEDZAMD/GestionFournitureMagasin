package com.aulsh.GestionFournitureMagasin.controller.api;


import com.aulsh.GestionFournitureMagasin.DTO.CommandeAgantDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aulsh.GestionFournitureMagasin.utils.Constants.APP_ROOT;


@CrossOrigin(origins = "http://localhost:4200")

@Api(APP_ROOT+ "/commandeAgent")
public interface CammandAgentApi {

    @PostMapping(value =  APP_ROOT + "/commandeAgent/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister une commande agent (Ajouter / Modifier)", notes = "cette methode pour enregistrer et modifier une commande agent",response = CommandeAgantDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l'objet commande  agent cree / modifie"),
            @ApiResponse(    code = 400, message = "l'objet commande agent nest pas valide")

    })
    CommandeAgantDto save(@RequestBody  CommandeAgantDto commandeAgantDto);

    @GetMapping(value =  APP_ROOT + "/commandeAgent/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une commande agent ", notes = "cette methode permet de rechercher une commande agent  par  ID ",response = CommandeAgantDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "la commande agent a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucune commande agent trouver dans la BB avec ID fourni")

    })
    CommandeAgantDto findById(@PathVariable("id") Integer idCommandeAgent);


    @GetMapping(value =  APP_ROOT + "/commandeAgent/codeCommandeAgent/{codeCommandeAgent}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une commande agent ", notes = "cette methode permet de rechercher une commande agent  par son code ",response = CommandeAgantDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "lobjet commande agent a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucune commande  trouver dans la BB avec code fourni")

    })

    CommandeAgantDto findBycode(@PathVariable("codeCommandeAgent") String codeCommandeAgent);



    @GetMapping (value =  APP_ROOT + "/commandeAgent/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des commande agents  ", notes = "cette methode permet de rechercher et renvoyer la liste des commandes agents  dans La BDD ",responseContainer ="List<CommandeAgantDto>" )
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "La liste des commandes agents / liste vide")})

    List<CommandeAgantDto> findAll();


    @DeleteMapping(value =  APP_ROOT + "/commandeAgent/delete/{id}")
    @ApiOperation(value = "supprimer une commande agent ", notes = "cette methode permet de suprimer une commande agent  par son ID ",response = CommandeAgantDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "la commande agent a ete Supprimer ")

    })
    void delete(@PathVariable("id") Integer id);

}
