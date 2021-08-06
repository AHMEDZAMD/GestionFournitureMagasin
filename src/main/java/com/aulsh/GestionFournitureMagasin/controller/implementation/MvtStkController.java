package com.aulsh.GestionFournitureMagasin.controller.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.MvmStockDto;
import com.aulsh.GestionFournitureMagasin.controller.api.MvtStkApi;
import com.aulsh.GestionFournitureMagasin.services.MvtStkService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvtStkController implements MvtStkApi {

  private MvtStkService service;

  @Autowired
  public MvtStkController(MvtStkService service){

    this.service=service;
  }

  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    return service.stockReelArticle(idArticle);
  }

  @Override
  public List<MvmStockDto> mvtStkArticle(Integer idArticle) {
    return service.mvtStkArticle(idArticle);
  }

  @Override
  public MvmStockDto entreeStock(MvmStockDto dto) {
    return service.entreeStock(dto);
  }

  @Override
  public MvmStockDto sortieStock(MvmStockDto dto) {
    return service.sortieStock(dto);
  }

  @Override
  public MvmStockDto correctionStockPos(MvmStockDto dto) {
    return service.correctionStockPos(dto);
  }

  @Override
  public MvmStockDto correctionStockNeg(MvmStockDto dto) {
    return service.correctionStockNeg(dto);
  }
}
