package com.aulsh.GestionFournitureMagasin.DTO;


import com.aulsh.GestionFournitureMagasin.model.AULSH;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AULSHDto {
    private  Integer Id;


    private String Nom;
    private Integer NombreAgent;
    private String Descprtion;


    private List<UtilisateurDto> utilisateurs;

    public static AULSHDto FromEntity(AULSH aulsh){


        if(aulsh == null){
            return  null;
        }

        return AULSHDto.builder()
                .Id(aulsh.getId())
                .NombreAgent(aulsh.getNombreAgent())
                .Descprtion(aulsh.getDescprtion())
                .build();
    }


    public static AULSH ToEntity(AULSHDto aulshDto){

        if (aulshDto == null){

            return null;
        }

        AULSH aulsh = new AULSH();
        aulsh.setId(aulshDto.getId());
        aulsh.setDescprtion(aulshDto.getDescprtion());
        aulsh.setNombreAgent(aulshDto.getNombreAgent());

        return aulsh;
    }

}
