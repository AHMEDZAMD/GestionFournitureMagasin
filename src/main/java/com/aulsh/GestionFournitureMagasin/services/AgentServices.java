package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.AgentDto;

import java.util.List;

public interface AgentServices {


    AgentDto save(AgentDto agentDto);
    AgentDto findById(Integer id);
    AgentDto findByemailAgent(String emailAdress);

    List<AgentDto> findAll();
    void delete(Integer id);


}
