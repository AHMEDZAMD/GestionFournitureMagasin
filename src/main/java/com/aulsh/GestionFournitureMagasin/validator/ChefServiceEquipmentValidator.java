package com.aulsh.GestionFournitureMagasin.validator;

import com.aulsh.GestionFournitureMagasin.DTO.ChefServiceEquipmentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ChefServiceEquipmentValidator {
    public static List<String> validate(ChefServiceEquipmentDto chefServiceEquipmentDto) {
        List<String> errors = new ArrayList<>();


        if (chefServiceEquipmentDto == null){


            errors.add("Vieullez remplir le nom de chef de service equipment");
            errors.add("Vieullez remplir le Prenom de chef de service equipment");
            errors.add("Vieullez remplir l'email Adress de chef de service equipment ");
            errors.add("Vieullez remplir le numero de telefon de chef de service equipment ");
            errors.add("Vieullez remplir la fonction de chef de service equipment ");

            return errors;

        }

        if (!StringUtils.hasLength(chefServiceEquipmentDto.getNom())) {
            errors.add("Vieullez remplir le nom de chef de service equipment");
        }

        if (!StringUtils.hasLength(chefServiceEquipmentDto.getPrenom())) {
            errors.add("Vieullez remplir le Prenom de chef de service equipment");

        }

        if (!StringUtils.hasLength(chefServiceEquipmentDto.getEmailAdress())) {
            errors.add("Vieullez remplir l'email Adress de chef de service equipment ");
        }


        if (!StringUtils.hasLength(chefServiceEquipmentDto.getNumTel())) {
            errors.add("Vieullez remplir le numero de telefon de chef de service equipment ");
        }
        if (!StringUtils.hasLength(chefServiceEquipmentDto.getFonction())) {
            errors.add("Vieullez remplir la fonction de chef de service equipment ");
        }

        return errors;
    }

}
