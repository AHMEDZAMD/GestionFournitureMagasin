package com.aulsh.GestionFournitureMagasin.DTO;

import com.aulsh.GestionFournitureMagasin.model.ChefDepartement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChefDepartementDto {

    private  Integer Id;


    private String Nom;
    private String Prenom;
    private String EmailAdress;
    private String Photo;
    private String NumTel;
    private String Fonction;

    public static ChefDepartementDto FromEntity(ChefDepartement chefDepartement){

        if (chefDepartement == null){

            // TODO an exception

            return null;

        }

        return ChefDepartementDto.builder()
                .Id(chefDepartement.getId())
                .Nom(chefDepartement.getNom())
                .Prenom(chefDepartement.getPrenom())
                .EmailAdress(chefDepartement.getEmailAdress())
                .Photo(chefDepartement.getPhoto())
                .NumTel(chefDepartement.getNumTel())
                .Fonction(chefDepartement.getFonction())
                .build();
    }



    public static ChefDepartement ToEntity(ChefDepartementDto chefDepartementDto){

        if (chefDepartementDto == null ){

            //TODO an exception

            return null;
        }

        ChefDepartement chefDepartement = new ChefDepartement();
        chefDepartement.setId(chefDepartementDto.getId());
        chefDepartement.setNom(chefDepartementDto.getNom());
        chefDepartement.setPrenom(chefDepartementDto.getPrenom());
        chefDepartement.setEmailAdress(chefDepartementDto.getEmailAdress());
        chefDepartement.setPhoto(chefDepartementDto.getPhoto());
        chefDepartement.setNumTel(chefDepartementDto.getNumTel());
        chefDepartement.setFonction(chefDepartementDto.getFonction());

        return chefDepartement;
    }

}
