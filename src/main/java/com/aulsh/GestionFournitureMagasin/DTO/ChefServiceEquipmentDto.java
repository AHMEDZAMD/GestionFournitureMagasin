package com.aulsh.GestionFournitureMagasin.DTO;


import com.aulsh.GestionFournitureMagasin.model.ChefServiceEquipements;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ChefServiceEquipmentDto {
    private  Integer Id;


    private String Nom;
    private String Prenom;
    private String emailAdress;
    private String Photo;
    private String NumTel;
    private String Fonction;


    private List<CmdeChefServiceEquipmentDto> CmdeChefServiceEquipment;

    public static ChefServiceEquipmentDto FromEntity(ChefServiceEquipements chefServiceEquipements){

        if (chefServiceEquipements == null){
            return null;

        }

        return ChefServiceEquipmentDto.builder()
                .Id(chefServiceEquipements.getId())
                .Nom(chefServiceEquipements.getNom())
                .Prenom(chefServiceEquipements.getPrenom())
                .emailAdress(chefServiceEquipements.getEmailAdress())
                .NumTel(chefServiceEquipements.getNumTel())
                .Fonction(chefServiceEquipements.getFonction())
                .build();


    }


    public static ChefServiceEquipements ToEntity(ChefServiceEquipmentDto chefServiceEquipmentDto){

        if (chefServiceEquipmentDto == null){

            return null;

        }


        ChefServiceEquipements chefServiceEquipements = new ChefServiceEquipements();
        chefServiceEquipements.setId(chefServiceEquipmentDto.getId());
        chefServiceEquipements.setNom(chefServiceEquipmentDto.getNom());
        chefServiceEquipements.setPrenom(chefServiceEquipements.getPrenom());
        chefServiceEquipements.setEmailAdress(chefServiceEquipmentDto.getEmailAdress());
        chefServiceEquipements.setNumTel(chefServiceEquipmentDto.getNumTel());
        chefServiceEquipements.setFonction(chefServiceEquipmentDto.getFonction());


        return chefServiceEquipements;
    }

}
