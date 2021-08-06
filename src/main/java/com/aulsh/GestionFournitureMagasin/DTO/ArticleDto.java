package com.aulsh.GestionFournitureMagasin.DTO;



import com.aulsh.GestionFournitureMagasin.model.Article;
import com.aulsh.GestionFournitureMagasin.model.Category;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {
    private  Integer Id;


    private String codeArticle;

    private String Designation;

    private BigDecimal PrixUnitaire;

    private BigDecimal TauxTva;

    private BigDecimal PrixUnitaireTcc;

    private String photo;


    private Category category;

    public static ArticleDto FromEntity(Article article){


        if (article==null){
            // TODO an exception
            return null;

        }

        return ArticleDto.builder()
                .Id(article.getId())
                .codeArticle(article.getCodeArticle())
                .Designation(article.getDesignation())
                .PrixUnitaire(article.getPrixUnitaire())
                .TauxTva(article.getTauxTva())
                .PrixUnitaireTcc(article.getPrixUnitaireTcc())
                .photo(article.getPhoto())
                .build();
    }

    public static Article ToEntity(ArticleDto articleDto){

        if (articleDto==null){

            // TODO an exception
            return  null;
        }


        Article article = new Article();

        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaire(articleDto.getPrixUnitaire());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTcc(articleDto.getPrixUnitaireTcc());
        article.setPhoto(articleDto.getPhoto());

        return article;
    }

}
