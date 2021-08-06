package com.aulsh.GestionFournitureMagasin.DTO;

import com.aulsh.GestionFournitureMagasin.model.Magazin;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class MagazinDto {


    private  Integer Id;

    private Integer NumbretotalArticles;
    private String  NomSocial;
    private Instant DateCreation;
    private Integer chiffreaffaire;

    private List<ArticleDto> articles;

    public static MagazinDto FromEntity(Magazin magazin){

        if (magazin == null){

            return null;

        }
        return MagazinDto.builder()
                .Id(magazin.getId())
                .NumbretotalArticles(magazin.getNumbretotalArticles())
                .NomSocial(magazin.getNomSocial())
                .DateCreation(magazin.getDateCreation())
                .chiffreaffaire(magazin.getChiffreaffaire())
                .build();
    }

    public static Magazin ToEntity(MagazinDto magazinDto){

        if (magazinDto == null){
            return null;
        }

        Magazin magazin = new Magazin();
        magazin.setId(magazinDto.getId());
        magazin.setNomSocial(magazinDto.getNomSocial());
        magazin.setNumbretotalArticles(magazinDto.getNumbretotalArticles());
        magazin.setDateCreation(magazinDto.getDateCreation());
        magazin.setChiffreaffaire(magazinDto.getChiffreaffaire());

        return magazin;
    }



}
