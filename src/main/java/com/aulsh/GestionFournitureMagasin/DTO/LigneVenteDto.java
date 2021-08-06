package com.aulsh.GestionFournitureMagasin.DTO;

import com.aulsh.GestionFournitureMagasin.model.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    private VentesDto vente;

    private ArticleDto article;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idMagazin;

    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VentesDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.FromEntity(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idMagazin(ligneVente.getIdMagazin())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto dto) {
        if (dto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(dto.getId());
        ligneVente.setVente(VentesDto.toEntity(dto.getVente()));
        ligneVente.setArticle(ArticleDto.ToEntity(dto.getArticle()));
        ligneVente.setQuantite(dto.getQuantite());
        ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
        ligneVente.setIdMagazin(dto.getIdMagazin());
        return ligneVente;
    }

}
