package com.aulsh.GestionFournitureMagasin.controller.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.ArticleDto;
import com.aulsh.GestionFournitureMagasin.controller.api.ArticleApi;
import com.aulsh.GestionFournitureMagasin.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ArticleController implements ArticleApi {


    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findBycodeArticle(String CodeArticle) {
        return articleService.findBycodeArticle(CodeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);

    }
}
