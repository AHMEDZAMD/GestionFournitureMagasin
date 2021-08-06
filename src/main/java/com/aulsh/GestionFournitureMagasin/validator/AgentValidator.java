package com.aulsh.GestionFournitureMagasin.validator;

import com.aulsh.GestionFournitureMagasin.DTO.AgentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AgentValidator {

    public static List<String> validate(AgentDto agentDto) {

        List<String> errors = new ArrayList<>();


        if (agentDto == null){
            errors.add("Veuillez renseigner le Nom  de l'agent");
            errors.add("Veuillez renseigner le Prenom  de l'agent");
            errors.add("Veuillez renseigner le numro Tele  de l'agent");
            errors.add("Veuillez renseigner la fonction  de l'agent");

            return errors;

        }

        if (!StringUtils.hasLength(agentDto.getNom())){

            errors.add("Veuillez renseigner le Nom  de l'agent");

        }


        if (!StringUtils.hasLength(agentDto.getPrenom())){

            errors.add("Veuillez renseigner le Prenom  de l'agent");

        }



        if (!StringUtils.hasLength(agentDto.getNumTel())){

            errors.add("Veuillez renseigner le numro Tele  de l'agent");

        }

        if (!StringUtils.hasLength(agentDto.getFonction())){

            errors.add("Veuillez renseigner la fonction  de l'agent");

        }

        return errors;
    }
}
