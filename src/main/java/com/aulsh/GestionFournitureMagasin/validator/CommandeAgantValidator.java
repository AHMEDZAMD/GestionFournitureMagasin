package com.aulsh.GestionFournitureMagasin.validator;

import com.aulsh.GestionFournitureMagasin.DTO.CommandeAgantDto;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

public class CommandeAgantValidator {


    public static List<String> validate(CommandeAgantDto dto) {

        List<String> errors = new ArrayList<>();



        if (dto == null){
            errors.add("Veuillez renseigner le code de la Commande");
            errors.add("Veuillez renseigner la date Commande  ");
            errors.add("Veuillez selectionnerr  Un Agent  pour La commande");

            return errors;

        }

        if (!StringUtils.hasLength(dto.getCode())){

            errors.add("Veuillez renseigner le code de la commande");
        }


        if (dto.getDateCommande() == null){

            errors.add("Veuillez renseigner La date de la commande");
        }

        if (dto.getAgent()==null){


            errors.add("Veuillez selectionnerr  Un Agent pour la Commande");
        }



        return errors;

        }
}
