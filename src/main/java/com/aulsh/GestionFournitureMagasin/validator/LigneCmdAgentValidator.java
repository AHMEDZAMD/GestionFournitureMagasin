package com.aulsh.GestionFournitureMagasin.validator;

import com.aulsh.GestionFournitureMagasin.DTO.LigneCmdeAgentDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCmdAgentValidator {


    public static List<String> validate(LigneCmdeAgentDto dto) {

        List<String> errors = new ArrayList<>();


        if (dto == null){
            errors.add("Veuillez renseigner la quantite ");
            errors.add("Veuillez renseigner le prix unitaire  ");
            errors.add("Veuillez selectionnerr  un article  pour la ligne de commande ");

            return errors;

        }


        if (dto.getPrixUnitaire() == null){

            errors.add("Veuillez renseigner le prix unitaire ");
        }

        if (dto.getQuantite() == null){

            errors.add("Veuillez renseigner la quantite  ");
        }

        if (dto.getArticle() == null){

            errors.add("Veuillez selectionnerr  un article  pour la ligne de commande   ");
        }


        return errors;
    }
}
