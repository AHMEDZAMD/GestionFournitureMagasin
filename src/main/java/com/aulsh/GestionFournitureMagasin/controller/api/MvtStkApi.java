package com.aulsh.GestionFournitureMagasin.controller.api;

import static com.aulsh.GestionFournitureMagasin.utils.Constants.APP_ROOT;

import com.aulsh.GestionFournitureMagasin.DTO.MvmStockDto;
import io.swagger.annotations.Api;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(APP_ROOT + "/mvtstk")
public interface MvtStkApi {

  @GetMapping(APP_ROOT + "/mvtstk/stockreel/{idArticle}")
  BigDecimal stockReelArticle(@PathVariable("idArticle") Integer idArticle);

  @GetMapping(APP_ROOT + "/mvtstk/filter/article/{idArticle}")
  List<MvmStockDto> mvtStkArticle(@PathVariable("idArticle") Integer idArticle);

  @PostMapping(APP_ROOT + "/mvtstk/entree")
  MvmStockDto entreeStock(@RequestBody MvmStockDto dto);

  @PostMapping(APP_ROOT + "/mvtstk/sortie")
  MvmStockDto sortieStock(@RequestBody MvmStockDto dto);

  @PostMapping(APP_ROOT + "/mvtstk/correctionpos")
  MvmStockDto correctionStockPos(@RequestBody MvmStockDto dto);

  @PostMapping(APP_ROOT + "/mvtstk/correctionneg")
  MvmStockDto correctionStockNeg(@RequestBody MvmStockDto dto);

}
