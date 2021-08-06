package com.aulsh.GestionFournitureMagasin.controller.implementation;


import com.aulsh.GestionFournitureMagasin.DTO.CommandeAgantDto;
import com.aulsh.GestionFournitureMagasin.controller.api.CammandAgentApi;
import com.aulsh.GestionFournitureMagasin.services.CommandeAgantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class CammandAgentController implements CammandAgentApi {

    private final CommandeAgantService commandeAgantService;

    @Autowired
    private CammandAgentController(CommandeAgantService commandeAgantService){

        this.commandeAgantService = commandeAgantService;
    }

    @Override
    public CommandeAgantDto save(CommandeAgantDto commandeAgantDto) {
        return commandeAgantService.save(commandeAgantDto);
    }

    @Override
    public CommandeAgantDto findById(Integer idCommandeAgent) {
        return commandeAgantService.findById(idCommandeAgent);
    }

    @Override
    public CommandeAgantDto findBycode(String codeCommandeAgent) {
        return commandeAgantService.findBycode(codeCommandeAgent);
    }

    @Override
    public List<CommandeAgantDto> findAll() {
        return commandeAgantService.findAll();
    }

    @Override
    public void delete(Integer id) {
        commandeAgantService.delete(id);
    }
}
