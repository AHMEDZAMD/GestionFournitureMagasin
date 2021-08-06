package com.aulsh.GestionFournitureMagasin.controller.api;


import com.aulsh.GestionFournitureMagasin.DTO.CmdeChefServiceEquipmentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aulsh.GestionFournitureMagasin.utils.Constants.APP_ROOT;

@Api(APP_ROOT+ "/CommandChefServiceEquipment")
public interface CommandChefServiceEquiApi {

    @PostMapping(value =  APP_ROOT + "/CommandChefServiceEquipment/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister une Commande Chef Service Equipment (Ajouter / Modifier)", notes = "cette methode pour enregistrer et modifier un agent",response = CmdeChefServiceEquipmentDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l'objet CmdeChefServiceEquipment cree / modifie"),
            @ApiResponse(    code = 400, message = "l'objet CmdeChefServiceEquipment nest pas valide")

    })


    CmdeChefServiceEquipmentDto save(@RequestBody  CmdeChefServiceEquipmentDto dto);


    @GetMapping(value =  APP_ROOT + "/CommandChefServiceEquipment/{idCmdeChefServiceEquipment}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un Commande Chef Service Equipment ", notes = "cette methode permet de rechercher une Commande Chef Service Equipment  par  ID ",response = CmdeChefServiceEquipmentDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l Commande Chef Service Equipment a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucun Commande Chef Service Equipment trouver dans la BB avec ID fourni")

    })
    CmdeChefServiceEquipmentDto findById(@PathVariable("idCmdeChefServiceEquipment") Integer idCmdeChefServiceEquipment);

    @GetMapping(value =  APP_ROOT + "/CommandChefServiceEquipment/{codeCmdeChefServiceEquipment}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une Commande Chef Service Equipment ", notes = "cette methode permet de rechercher une Commande Chef Service Equipment  par  code ",response = CmdeChefServiceEquipmentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l Commande Chef Service Equipment a ete trouver dans la BD"),
            @ApiResponse(code = 404, message = "Aucun Commande Chef Service Equipment trouver dans la BB avec code fourni")
    })
    CmdeChefServiceEquipmentDto findByCmdChefServiceEquipment(@PathVariable("codeCmdeChefServiceEquipment") String codeCmdeChefServiceEquipment);

    @GetMapping (value =  APP_ROOT + "/CommandChefServiceEquipment/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des Commandes Chef Service Equipment  ", notes = "cette methode permet de rechercher et renvoyer la liste des Commande Chef Service Equipment  dans La BDD ",responseContainer ="List<CmdeChefServiceEquipmentDto>" )
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "La liste des Commandes Chef Service Equipment / liste vide")})

    List<CmdeChefServiceEquipmentDto> findAll();

    @DeleteMapping(value =  APP_ROOT + "/CommandChefServiceEquipment/delete/{idCmdeChefServiceEquipment}")
    @ApiOperation(value = "supprimer une Commande Chef Service ", notes = "cette methode permet de suprimer une Commande Chef Service Equipment  par  ID ",response = CmdeChefServiceEquipmentDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "la Commande Chef Service Equipment a ete Supprimer ")

    })
    void delete(@PathVariable("idCmdeChefServiceEquipment") Integer id);

}
