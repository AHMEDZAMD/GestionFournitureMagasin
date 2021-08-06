package com.aulsh.GestionFournitureMagasin.services.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.CmdeChefServiceEquipmentDto;


import com.aulsh.GestionFournitureMagasin.DTO.LigneCmdeChefServiceEquipmentDto;
import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.Article;
import com.aulsh.GestionFournitureMagasin.model.ChefServiceEquipements;
import com.aulsh.GestionFournitureMagasin.model.CmdeChefServiceEquipment;
import com.aulsh.GestionFournitureMagasin.model.LigneCmdeChefServiceEquipment;
import com.aulsh.GestionFournitureMagasin.repository.*;
import com.aulsh.GestionFournitureMagasin.services.CmdChefServiceEquipmentService;
import com.aulsh.GestionFournitureMagasin.validator.CmdChefServiceEquipmentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CmdChefServiceEquipmentServiceImp implements CmdChefServiceEquipmentService {

    private CmdChefServiceEquipmentRepository cmdChefServiceEquipmentRepository;
    private LigneCmdeChefServiceEquipmentRepository ligneCmdeChefServiceEquipmentRepository;
    private ChefServiceEquipmentRepository chefServiceEquipmentRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CmdChefServiceEquipmentServiceImp(CmdChefServiceEquipmentRepository cmdChefServiceEquipmentRepository,
      LigneCmdeChefServiceEquipmentRepository ligneCmdeChefServiceEquipmentRepository,ChefServiceEquipmentRepository chefServiceEquipmentRepository,
       ArticleRepository articleRepository ){

        this.cmdChefServiceEquipmentRepository=cmdChefServiceEquipmentRepository;
        this.ligneCmdeChefServiceEquipmentRepository = ligneCmdeChefServiceEquipmentRepository;
        this.chefServiceEquipmentRepository=chefServiceEquipmentRepository;
        this.articleRepository=articleRepository;

    }

    @Override
    public CmdeChefServiceEquipmentDto save(CmdeChefServiceEquipmentDto dto) {

        List<String> errors = CmdChefServiceEquipmentValidator.validate(dto);

        if (!errors.isEmpty()) {

            log.error("la commande de chef Service nest pas valid");
            throw new InvalidEntityException("la commande d'de chef Service Equipment  nest pas valid", ErrorCodes.COMMANDE_CHEF_SERVICE_EQUIPMENTS_NOT_FOUND);

        }

        Optional<ChefServiceEquipements> chefServiceEquipements = chefServiceEquipmentRepository.findById(dto.getChefServiceEquipements().getId());

        if (chefServiceEquipements.isEmpty()) {

            log.warn("Chef Service Equipment with ID{} not found on the the DB", dto.getChefServiceEquipements().getId());
            throw new EntityNotFoundException("Aucun Chef S avec ID" + dto.getChefServiceEquipements().getId() + "na trouve dans la BD", ErrorCodes.CHEF_SERVICE_EQUIPMENTS_NOT_FOUND);

        }

        List<String> articleErrors = new ArrayList<>();



        if (dto.getLigneCmdeChefServiceEquipmentDtos() != null) {

            dto.getLigneCmdeChefServiceEquipmentDtos().forEach(LignCmdAg -> {

                if (LignCmdAg.getArticle() != null) {

                    Optional<Article> article = articleRepository.findById(LignCmdAg.getArticle().getId());

                    if (article.isEmpty()) {

                        articleErrors.add("l article avec Id:" + LignCmdAg.getArticle().getId() + "n'est pas existe dans BD");
                    }
                }

            });

        }

        if (!articleErrors.isEmpty()) {

            log.warn("");
            throw new InvalidEntityException("Article Not Exist on DB", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        CmdeChefServiceEquipment SavedCmdChef = cmdChefServiceEquipmentRepository.save((CmdeChefServiceEquipmentDto.ToEntity(dto)));

        if (dto.getLigneCmdeChefServiceEquipmentDtos() != null) {

            dto.getLigneCmdeChefServiceEquipmentDtos().forEach(LigCmdAg -> {

                LigneCmdeChefServiceEquipment ligneCmdeChef = LigneCmdeChefServiceEquipmentDto.ToEntity(LigCmdAg);
                ligneCmdeChef.setCmdeChefServiceEquipment(SavedCmdChef);
                ligneCmdeChefServiceEquipmentRepository.save(ligneCmdeChef);

            });


        }
        return CmdeChefServiceEquipmentDto.FromEntity(SavedCmdChef);


        }

    @Override
    public CmdeChefServiceEquipmentDto findById(Integer id) {
        if (id == null) {

            log.error("Commade Agent IS NULL");
            return null;
        }


        return cmdChefServiceEquipmentRepository.findById(id)
                .map(CmdeChefServiceEquipmentDto::FromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("aucun Commande  de chef service equipment avec l ID = " + id + "n est pas trouver dans la BDD",
                                ErrorCodes.COMMANDE_CHEF_SERVICE_EQUIPMENTS_NOT_FOUND));    }

    @Override
    public CmdeChefServiceEquipmentDto findByCmdChefServiceEquipment(String code) {


        if (!StringUtils.hasLength(code)) {

            log.error("Commande de chef Service equipment CODE is Null");
            return null;
        }

        return cmdChefServiceEquipmentRepository.findCmdeChefServiceEquipmentByCode(code)
                .map(CmdeChefServiceEquipmentDto::FromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("aucun Commande de chef Service equipment avec le Code = " + code + "n est pas trouver dans la BDD",
                                ErrorCodes.COMMANDE_CHEF_SERVICE_EQUIPMENTS_NOT_FOUND));
    }

    @Override
    public List<CmdeChefServiceEquipmentDto> findAll() {
        return cmdChefServiceEquipmentRepository.findAll().stream()  /// findAll predifine Function
                .map(CmdeChefServiceEquipmentDto::FromEntity)   /// faire le mapping d une Commande de chef Service equipment  a l autre avec methode refrence FromEntity
                .collect(Collectors.toList());  /// collecter et regreouper dans une list
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {

            log.error("Id of Chef Service Equipmen  Is Null");

            return;
        }

        cmdChefServiceEquipmentRepository.deleteById(id);
    }


}
