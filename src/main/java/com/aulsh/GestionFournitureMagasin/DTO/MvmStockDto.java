package com.aulsh.GestionFournitureMagasin.DTO;

import com.aulsh.GestionFournitureMagasin.model.MvmStock;
import com.aulsh.GestionFournitureMagasin.model.SourceMvtStk;
import com.aulsh.GestionFournitureMagasin.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvmStockDto {

    private  Integer Id;


    private Instant Dateachat;
    private Integer NombreAchatparArticl;
    private BigDecimal quantity;
    private TypeMvtStk typeMvt;

    private SourceMvtStk sourceMvt;


    private ArticleDto article;


    public static MvmStockDto FromEntity(MvmStock mvmStock){

        if (mvmStock == null){

            return null;

        }
        return MvmStockDto.builder()
                .Id(mvmStock.getId())
                .Dateachat(mvmStock.getDateachat())
                .NombreAchatparArticl(mvmStock.getNombreAchatparArticl())
                .quantity(mvmStock.getQuantity())
                .sourceMvt(mvmStock.getSourceMvt())
                .typeMvt(mvmStock.getTypeMvt())
                .build();

    }


    public static MvmStock ToEntity(MvmStockDto mvmStockDto){
       if (mvmStockDto == null){

           return null;

       }
        MvmStock mvmStock = new MvmStock();
       mvmStock.setId(mvmStockDto.getId());
       mvmStock.setDateachat(mvmStockDto.getDateachat());
       mvmStock.setNombreAchatparArticl(mvmStockDto.getNombreAchatparArticl());
       mvmStock.setQuantity(mvmStockDto.getQuantity());
        mvmStock.setSourceMvt(mvmStockDto.getSourceMvt());
        mvmStock.setTypeMvt(mvmStockDto.getTypeMvt());


       return mvmStock;
    }
}
