package com.aulsh.GestionFournitureMagasin.services.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.MvmStockDto;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.TypeMvtStk;
import com.aulsh.GestionFournitureMagasin.repository.MvtStkRepository;
import com.aulsh.GestionFournitureMagasin.services.ArticleService;
import com.aulsh.GestionFournitureMagasin.services.MvtStkService;
import com.aulsh.GestionFournitureMagasin.validator.MvtStkValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class MvmStkImpl implements MvtStkService {
    private MvtStkRepository repository;
    private ArticleService articleService;

    @Autowired
    public MvmStkImpl(MvtStkRepository repository, ArticleService articleService) {
        this.repository = repository;
        this.articleService = articleService;
    }

    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        if (idArticle == null) {
            log.warn("ID article is NULL");
            return BigDecimal.valueOf(-1);
        }
        articleService.findById(idArticle);
        return repository.stockReelArticle(idArticle);
    }

    @Override
    public List<MvmStockDto> mvtStkArticle(Integer idArticle) {
        return repository.findAllByArticleId(idArticle).stream()
                .map(MvmStockDto::FromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MvmStockDto entreeStock(MvmStockDto dto) {
        return entreePositive(dto, TypeMvtStk.ENTREE);
    }

    @Override
    public MvmStockDto  sortieStock(MvmStockDto dto) {
        return sortieNegative(dto, TypeMvtStk.SORTIE);
    }

    @Override
    public MvmStockDto correctionStockPos(MvmStockDto dto) {
        return entreePositive(dto, TypeMvtStk.CORRECTION_POS);
    }

    @Override
    public MvmStockDto correctionStockNeg(MvmStockDto dto) {
        return sortieNegative(dto, TypeMvtStk.CORRECTION_NEG);
    }

    private MvmStockDto entreePositive(MvmStockDto dto, TypeMvtStk typeMvtStk) {
        List<String> errors = MvtStkValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }
        dto.setQuantity(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantity().doubleValue())
                )
        );
        dto.setTypeMvt(typeMvtStk);
        return MvmStockDto.FromEntity(
                repository.save(MvmStockDto.ToEntity(dto))
        );
    }

    private MvmStockDto sortieNegative(MvmStockDto dto, TypeMvtStk typeMvtStk) {
        List<String> errors = MvtStkValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }
        dto.setQuantity(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantity().doubleValue()) * -1
                )
        );
        dto.setTypeMvt(typeMvtStk);
        return MvmStockDto.FromEntity(
                repository.save(MvmStockDto.ToEntity(dto))
        );
    }
}
