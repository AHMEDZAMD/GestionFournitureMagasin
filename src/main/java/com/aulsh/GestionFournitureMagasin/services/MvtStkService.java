package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.MvmStockDto;

import java.math.BigDecimal;
import java.util.List;

public interface MvtStkService {


    BigDecimal stockReelArticle(Integer idArticle);

    List<MvmStockDto> mvtStkArticle(Integer idArticle);

    MvmStockDto entreeStock(MvmStockDto dto);

    MvmStockDto sortieStock(MvmStockDto dto);

    MvmStockDto correctionStockPos(MvmStockDto dto);

    MvmStockDto correctionStockNeg(MvmStockDto dto);
}
