package com.aulsh.GestionFournitureMagasin.validator;

import com.aulsh.GestionFournitureMagasin.DTO.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();


        if (utilisateurDto == null){

            errors.add("Vieullez remplir le nom d'utilisateur");
            errors.add("Vieullez remplir le Prenom d'utilisateur");
            errors.add("Vieullez remplir le Mot de pass d'utilisateur");

            return errors;

        }
                if (!StringUtils.hasLength(utilisateurDto.getNom())) {
                    errors.add("Vieullez remplir le nom d'utilisateur");
                }

                if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
                    errors.add("Vieullez remplir le Prenom d'utilisateur");
                }

                if (!StringUtils.hasLength(utilisateurDto.getMotdepass())) {
                    errors.add("Vieullez remplir le Mot de pass d'utilisateur");
                }

                if (!StringUtils.hasLength(utilisateurDto.getEmailAdress())) {
                    errors.add("Vieullez remplir l'email Adress d'utilisateur");
                }


                if(utilisateurDto.getDateNaissance() == null){
                    errors.add("Vieullez remplir la date de naissance  d'utilisateur");

                }


        return errors;
    }
}
