package com.aulsh.GestionFournitureMagasin.DTO;


import com.aulsh.GestionFournitureMagasin.model.CommandeAgent;
import com.aulsh.GestionFournitureMagasin.model.LigneCmdeAgent;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeAgantDto {

    private  Integer Id;


    private String code;

    private Instant dateCommande;


    private List<LigneCmdeAgentDto> ligneCmdeAgentDtos;


    private AgentDto agent;

    public static CommandeAgantDto FromEntity(CommandeAgent commandeAgent){

        if (commandeAgent == null){
            return null;
        }

        return CommandeAgantDto.builder()
                .Id(commandeAgent.getId())
                .code(commandeAgent.getCode())
                .dateCommande(commandeAgent.getDateCommande())
                .build();
    }


    public static CommandeAgent ToEntity(CommandeAgantDto commandeAgantDto){


        if (commandeAgantDto == null){

            return null;
        }


        CommandeAgent commandeAgent = new CommandeAgent();
        commandeAgent.setId(commandeAgantDto.getId());
        commandeAgent.setCode(commandeAgantDto.getCode());
        commandeAgent.setDateCommande(commandeAgantDto.getDateCommande());
        return commandeAgent;
    }



}
