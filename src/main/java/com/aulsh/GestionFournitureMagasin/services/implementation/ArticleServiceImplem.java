package com.aulsh.GestionFournitureMagasin.services.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.ArticleDto;
import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.Article;
import com.aulsh.GestionFournitureMagasin.repository.ArticleRepository;
import com.aulsh.GestionFournitureMagasin.services.ArticleService;
import com.aulsh.GestionFournitureMagasin.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import java.util.stream.Collectors;


@Service
@Slf4j
public class ArticleServiceImplem implements ArticleService {


    private ArticleRepository articleRepository;

    @Autowired   //injection par constructeur
    public ArticleServiceImplem(ArticleRepository articleRepository){

        this.articleRepository =articleRepository;
    }
    @Override
    public ArticleDto save(ArticleDto articleDto) {

        List<String> errors = ArticleValidator.validate(articleDto);// la validation
        if (!errors.isEmpty()){
            log.error("Article n'est pas valid {}",articleDto);
            throw new InvalidEntityException("Article n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID);

        }

        Article savedArticle = articleRepository.save(ArticleDto.ToEntity(articleDto));
        return  ArticleDto.FromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {

        if (id == null){

            log.error("Article Id is null ");

            return null;
        }


        return articleRepository.findById(id)
                .map(ArticleDto::FromEntity)
                .orElseThrow(()->
                new EntityNotFoundException("aucun article avec l ID = "+id+"n est pas trouver dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));

    }

    @Override
    public ArticleDto findBycodeArticle(String codeArticle) {

        if (!StringUtils.hasLength(codeArticle)){

            log.error("Article CODE is Null");
            return null;
        }

        return articleRepository.findArticleByCodeArticle(codeArticle)
                .map(ArticleDto::FromEntity)
                .orElseThrow(()->
                new EntityNotFoundException("aucun article avec l CodeArticle = "+codeArticle+"n est pas trouver dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));

    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()  /// findAll predifine Function
                .map(ArticleDto::FromEntity)   /// faire le mapping d un article a l autre avec methode refrence FromEntity
                .collect(Collectors.toList());  /// collecter et regreouper dans une list
    }

    @Override
    public void delete(Integer id) {

        if (id == null){

            log.error("Id of Article Is Null");

            return;
        }

        articleRepository.deleteById(id);

    }
}
