package com.aulsh.GestionFournitureMagasin.controller.api;


import com.aulsh.GestionFournitureMagasin.DTO.AgentDto;
import com.aulsh.GestionFournitureMagasin.model.Agent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aulsh.GestionFournitureMagasin.utils.Constants.APP_ROOT;

@CrossOrigin(origins = "http://localhost:4200")
@Api(APP_ROOT+ "/agents")
public interface AgentApi {

    @PostMapping(value =  APP_ROOT + "/agents/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister un agent (Ajouter / Modifier)", notes = "cette methode pour enregistrer et modifier un agent",response = AgentDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l'objet agent cree / modifie"),
            @ApiResponse(    code = 400, message = "l'objet agent nest pas valide")

    })

    AgentDto save(@RequestBody  AgentDto agentDto);

    @GetMapping(value =  APP_ROOT + "/agents/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un agent ", notes = "cette methode permet de rechercher un agent  par son ID ",response = AgentDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l agent a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucun agent trouver dans la BB avec ID fourni")

    })
    AgentDto findById(@PathVariable("id")Integer id);


    @GetMapping(value =  APP_ROOT + "/agents/email/{emailAdress}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un agent ", notes = "cette methode permet de rechercher un agent  par son email adress ",response = AgentDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l agent a ete trouver dans la BD"),
            @ApiResponse(    code = 404, message = "Aucun agent trouver dans la BB avec Email fourni")

    })
    AgentDto findByemailAgent(@PathVariable("emailAdress")String emailAdress);

    @GetMapping (value =  APP_ROOT + "/agents/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoie la liste des agents  ", notes = "cette methode permet de rechercher et renvoyer la liste des agents  dans La BDD ",responseContainer ="List<AgentDto>" )
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "La liste des article / liste vide")})
    List<AgentDto> findAll();



    @DeleteMapping(value =  APP_ROOT + "/agents/delete/{id}")
    @ApiOperation(value = "supprimer un agent ", notes = "cette methode permet de suprimer un agent  par son ID ",response = AgentDto.class)
    @ApiResponses(value = {
            @ApiResponse(    code = 200, message = "l agent a ete Supprimer ")

    })
    void delete(@PathVariable("id") Integer id);


    @PutMapping("/agents/{id}")
    ResponseEntity<Agent> updateAgent(@PathVariable Integer id, @RequestBody Agent employeeDetails);
}
