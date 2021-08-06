package com.aulsh.GestionFournitureMagasin.controller.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.AgentDto;
import com.aulsh.GestionFournitureMagasin.controller.api.AgentApi;
import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.model.Agent;
import com.aulsh.GestionFournitureMagasin.repository.AgentRepository;
import com.aulsh.GestionFournitureMagasin.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

public class AgentController implements AgentApi {
    private final AgentRepository agentRepository;
    private final AgentServices agentServices;
    @Autowired
    public AgentController(AgentRepository agentRepository, AgentServices agentServices){
        this.agentRepository = agentRepository;

        this.agentServices = agentServices;
    }
    @Override
    public AgentDto save(AgentDto agentDto) {
        return agentServices.save(agentDto);
    }

    @Override
    public AgentDto findById(Integer id) {
        return agentServices.findById(id);
    }

    @Override
    public AgentDto findByemailAgent(String emailAdress) {
        return agentServices.findByemailAgent(emailAdress);
    }

    @Override
    public List<AgentDto> findAll() {
        return agentServices.findAll();
    }

    @Override
    public void delete(Integer id) {
        agentServices.delete(id);

    }

    @Override
    public ResponseEntity<Agent> updateAgent(Integer id, Agent employeeDetails) {
        Agent employee = agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("aucun Agent avec l ID = "+id+"n est pas trouver dans la BDD",
                        ErrorCodes.AGENT_NOT_FOUND));

        employee.setNom(employeeDetails.getNom());
        employee.setPrenom(employeeDetails.getPrenom());
        employee.setEmailAdress(employeeDetails.getEmailAdress());
        employee.setNumTel(employeeDetails.getNumTel());
        employee.setFonction(employeeDetails.getFonction());

        Agent updatedEmployee = agentRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
