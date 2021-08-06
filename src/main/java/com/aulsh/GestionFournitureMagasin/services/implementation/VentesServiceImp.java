package com.aulsh.GestionFournitureMagasin.services.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.ArticleDto;
import com.aulsh.GestionFournitureMagasin.DTO.LigneVenteDto;
import com.aulsh.GestionFournitureMagasin.DTO.MvmStockDto;
import com.aulsh.GestionFournitureMagasin.DTO.VentesDto;
import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.exception.InvalidOperationException;
import com.aulsh.GestionFournitureMagasin.model.*;
import com.aulsh.GestionFournitureMagasin.repository.ArticleRepository;
import com.aulsh.GestionFournitureMagasin.repository.LigneVenteRepository;
import com.aulsh.GestionFournitureMagasin.repository.VentesRepository;
import com.aulsh.GestionFournitureMagasin.services.MvtStkService;
import com.aulsh.GestionFournitureMagasin.services.VentesService;
import com.aulsh.GestionFournitureMagasin.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServiceImp implements VentesService {
    private ArticleRepository articleRepository;
    private VentesRepository ventesRepository;
    private LigneVenteRepository ligneVenteRepository;
    private MvtStkService mvtStkService;

    @Autowired
    public VentesServiceImp(ArticleRepository articleRepository, VentesRepository ventesRepository,
                             LigneVenteRepository ligneVenteRepository, MvtStkService mvtStkService) {
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.mvtStkService = mvtStkService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + " n'a ete trouve dans la BDD");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVentes);
            ligneVenteRepository.save(ligneVente);
            updateMvtStk(ligneVente);
        });

        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findBycodeVentes(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente client n'a ete trouve avec le CODE " + code, ErrorCodes.VENTE_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }
        List<LigneVente> ligneVentes = ligneVenteRepository.findAllByVenteId(id);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer une vente ...",
                    ErrorCodes.VENTE_ALREADY_IN_USE);
        }
        ventesRepository.deleteById(id);
    }

    private void updateMvtStk(LigneVente lig) {
        MvmStockDto mvtStkDto = MvmStockDto.builder()
                .article(ArticleDto.FromEntity(lig.getArticle()))
                .Dateachat(Instant.now())
                .typeMvt(TypeMvtStk.SORTIE)
                .sourceMvt(SourceMvtStk.VENTE)
                .quantity(lig.getQuantite())
                .build();
        mvtStkService.sortieStock(mvtStkDto);
    }
}
