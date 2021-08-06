package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findBycodeArticle(String codeArticle);

    List<ArticleDto> findAll();
    void delete(Integer id);


}
