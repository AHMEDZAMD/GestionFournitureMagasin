package com.aulsh.GestionFournitureMagasin.DTO;

import com.aulsh.GestionFournitureMagasin.model.LigneCmdeChefServiceEquipment;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LigneCmdeChefServiceEquipmentDto {

    private  Integer Id;


    private ArticleDto article;


    private CmdeChefServiceEquipmentDto CmdeChefServiceEquipment;


    public static LigneCmdeChefServiceEquipmentDto FromEntity(LigneCmdeChefServiceEquipment ligneCmdeChefServiceEquipment){

        if (ligneCmdeChefServiceEquipment == null){

            return null;
        }

        return LigneCmdeChefServiceEquipmentDto.builder()
                .Id(ligneCmdeChefServiceEquipment.getId())
                .build();
    }


    public static  LigneCmdeChefServiceEquipment ToEntity(LigneCmdeChefServiceEquipmentDto ligneCmdeChefServiceEquipmentDto){

        if (ligneCmdeChefServiceEquipmentDto == null){

            return null;

        }
        LigneCmdeChefServiceEquipment ligneCmdeChefServiceEquipment =  new LigneCmdeChefServiceEquipment();

        ligneCmdeChefServiceEquipment.setId(ligneCmdeChefServiceEquipmentDto.getId());

        return ligneCmdeChefServiceEquipment;
    }
}
