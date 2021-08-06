package com.aulsh.GestionFournitureMagasin.DTO;


import com.aulsh.GestionFournitureMagasin.model.Agent;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public class AgentDto {

    private  Integer Id;
    private String Nom;

    private String Prenom;

    private String emailAdress;

    private String Photo;

    private String NumTel;

    private String Fonction;

    private List<CommandeAgantDto> commandeAgantDtos;


    public static AgentDto FromEntity(Agent agent){

        if ( agent == null){
            //TODO an exception
            return null;
        }

        return AgentDto.builder()
                .Id(agent.getId())
                .Nom(agent.getNom())
                .Prenom(agent.getPrenom())
                .NumTel(agent.getNumTel())
                .Fonction(agent.getFonction())
                .emailAdress(agent.getEmailAdress())
                .build();

    }



    public static Agent ToEntity(AgentDto agentDto){

        if (agentDto == null){

            //TODO an exception

            return null;
        }

        Agent agent = new Agent();
        agent.setId(agentDto.getId());
        agent.setNom(agentDto.getNom());
        agent.setPrenom(agentDto.getPrenom());
        agent.setNumTel(agentDto.getNumTel());
        agent.setFonction(agentDto.getFonction());
        agent.setEmailAdress(agentDto.getEmailAdress());


        return agent;

    }
}
