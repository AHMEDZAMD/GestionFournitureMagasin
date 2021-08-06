package com.aulsh.GestionFournitureMagasin.DTO;


import com.aulsh.GestionFournitureMagasin.model.CmdeChefServiceEquipment;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CmdeChefServiceEquipmentDto {

    private  Integer Id;


    private String code;
    private Instant dateCommande;

    private List<LigneCmdeChefServiceEquipmentDto> ligneCmdeChefServiceEquipmentDtos;




    private ChefServiceEquipmentDto chefServiceEquipements;



    public static CmdeChefServiceEquipmentDto FromEntity(CmdeChefServiceEquipment cmdeChefServiceEquipment){

        if (cmdeChefServiceEquipment == null)
        {
            return null;

        }

        return  CmdeChefServiceEquipmentDto.builder()
                .Id(cmdeChefServiceEquipment.getId())
                .code(cmdeChefServiceEquipment.getCode())
                .dateCommande(cmdeChefServiceEquipment.getDateCommande())
                .build();
    }



    public static CmdeChefServiceEquipment ToEntity(CmdeChefServiceEquipmentDto cmdeChefServiceEquipmentDto){

        if (cmdeChefServiceEquipmentDto == null){
            return null;
        }

        CmdeChefServiceEquipment cmdeChefServiceEquipment = new CmdeChefServiceEquipment();

        cmdeChefServiceEquipment.setId(cmdeChefServiceEquipmentDto.getId());
        cmdeChefServiceEquipment.setCode(cmdeChefServiceEquipmentDto.getCode());
        cmdeChefServiceEquipment.setDateCommande(cmdeChefServiceEquipmentDto.getDateCommande());

        return cmdeChefServiceEquipment;
    }
}
