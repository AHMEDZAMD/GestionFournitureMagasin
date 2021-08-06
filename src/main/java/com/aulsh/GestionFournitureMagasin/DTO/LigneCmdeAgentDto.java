package com.aulsh.GestionFournitureMagasin.DTO;



import com.aulsh.GestionFournitureMagasin.model.CommandeAgent;
import com.aulsh.GestionFournitureMagasin.model.LigneCmdeAgent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
public class LigneCmdeAgentDto {

    private  Integer Id;
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private ArticleDto article;



    @JsonIgnore
    private CommandeAgantDto commandeAgent;

   public static LigneCmdeAgentDto FromEntity(LigneCmdeAgent ligneCmdeAgent){

       if (ligneCmdeAgent == null){

           return null;
       }

       return LigneCmdeAgentDto.builder()
               .Id(ligneCmdeAgent.getId())
               .quantite(ligneCmdeAgent.getQuantite())
               .prixUnitaire(ligneCmdeAgent.getPrixUnitaire())
               .build();
   }


   public static  LigneCmdeAgent ToEntity(LigneCmdeAgentDto ligneCmdeAgentDto){

       if (ligneCmdeAgentDto == null){

           return null;

       }
       LigneCmdeAgent ligneCmdeAgent =  new LigneCmdeAgent();

       ligneCmdeAgent.setId(ligneCmdeAgentDto.getId());
       ligneCmdeAgent.setQuantite(ligneCmdeAgentDto.getQuantite());
       ligneCmdeAgent.setPrixUnitaire(ligneCmdeAgentDto.getPrixUnitaire());

       return ligneCmdeAgent;
   }
}
