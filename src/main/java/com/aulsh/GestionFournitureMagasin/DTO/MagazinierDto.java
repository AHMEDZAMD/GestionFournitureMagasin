package com.aulsh.GestionFournitureMagasin.DTO;


import com.aulsh.GestionFournitureMagasin.model.Magasinier;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MagazinierDto {


    private  Integer Id;

    private String Nom;
    private String Prenom;
    private String EmailAdress;
    private String Photo;
    private String NumTel;


    public static MagazinierDto FromEntity(Magasinier magasinier){

        if (magasinier == null){

            return null;
        }
        return MagazinierDto.builder()
                .Id(magasinier.getId())
                .Nom(magasinier.getNom())
                .Prenom(magasinier.getPrenom())
                .EmailAdress(magasinier.getEmailAdress())
                .Photo(magasinier.getPhoto())
                .NumTel(magasinier.getNumTel())
                .build();
    }


    public static Magasinier ToEntity(MagazinierDto magazinierDto){

        if (magazinierDto == null){
            return null;

        }

        Magasinier magasinier = new Magasinier();
        magasinier.setId(magazinierDto.getId());
        magasinier.setNom(magazinierDto.getNom());
        magasinier.setPrenom(magazinierDto.getPrenom());
        magasinier.setEmailAdress(magazinierDto.getEmailAdress());
        magasinier.setPhoto(magazinierDto.getPhoto());
        magasinier.setNumTel(magazinierDto.getNumTel());


        return magasinier;

    }
}
