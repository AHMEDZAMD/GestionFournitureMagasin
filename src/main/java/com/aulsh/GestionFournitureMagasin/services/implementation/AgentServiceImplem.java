package com.aulsh.GestionFournitureMagasin.services.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.AgentDto;

import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.Agent;
import com.aulsh.GestionFournitureMagasin.repository.AgentRepository;
import com.aulsh.GestionFournitureMagasin.services.AgentServices;
import com.aulsh.GestionFournitureMagasin.validator.AgentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AgentServiceImplem implements AgentServices {

    private final AgentRepository agentRepository;


    @Autowired   //injection par constructeur
    public AgentServiceImplem(AgentRepository agentRepository){

        this.agentRepository =agentRepository;
    }



    @Override
    public AgentDto save(AgentDto agentDto) {
        List<String> errors = AgentValidator.validate(agentDto);// la validation
        if (!errors.isEmpty()){
            log.error("Agent n'est pas valid {}",agentDto);
            throw new InvalidEntityException("Agent n'est pas valid", ErrorCodes.AGENT_NOT_VALID);

        }

        Agent savedAgent = agentRepository.save(AgentDto.ToEntity(agentDto));
        return  AgentDto.FromEntity(savedAgent);
    }




    @Override
    public AgentDto findById(Integer id) {
        if (id == null){

            log.error("Agent Id is null ");

            return null;
        }


        return agentRepository.findById(id)
                .map(AgentDto::FromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Agent avec l ID = "+id+"n est pas trouver dans la BDD",
                                ErrorCodes.AGENT_NOT_FOUND));
    }

    @Override
    public AgentDto findByemailAgent(String emailAdress) {
        if (!StringUtils.hasLength(emailAdress)){

            log.error("AGENT Email is Null");
            return null;
        }

        return agentRepository.findAgentByEmailAdress(emailAdress)
                .map(AgentDto::FromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Agent avec l email = "+emailAdress+"n est pas trouver dans la BDD",
                                ErrorCodes.AGENT_NOT_FOUND));    }

    @Override
    public List<AgentDto> findAll() {
        return agentRepository.findAll().stream()  /// findAll predifine Function
                .map(AgentDto::FromEntity)   /// faire le mapping d un Agent a l autre avec methode refrence FromEntity
                .collect(Collectors.toList());  /// collecter et regreouper dans une list
    }

    @Override
    public void delete(Integer id) {

        if (id == null){

            log.error("Id of Agent Is Null");

            return;
        }

        agentRepository.deleteById(id);


    }
}
