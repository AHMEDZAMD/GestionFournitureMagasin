package com.aulsh.GestionFournitureMagasin.services.implementation;


import com.aulsh.GestionFournitureMagasin.DTO.CommandeAgantDto;
import com.aulsh.GestionFournitureMagasin.DTO.LigneCmdeAgentDto;
import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.Agent;
import com.aulsh.GestionFournitureMagasin.model.Article;
import com.aulsh.GestionFournitureMagasin.model.CommandeAgent;
import com.aulsh.GestionFournitureMagasin.model.LigneCmdeAgent;
import com.aulsh.GestionFournitureMagasin.repository.AgentRepository;
import com.aulsh.GestionFournitureMagasin.repository.ArticleRepository;
import com.aulsh.GestionFournitureMagasin.repository.CammandeAgentRepository;
import com.aulsh.GestionFournitureMagasin.repository.LigneCmdeAgentRepository;
import com.aulsh.GestionFournitureMagasin.services.CommandeAgantService;
import com.aulsh.GestionFournitureMagasin.validator.CommandeAgantValidator;
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
public class CommandeAgantServiceImpl implements CommandeAgantService {

    private LigneCmdeAgentRepository ligneCmdeAgentRepository;
    private CammandeAgentRepository cammandeAgentRepository;
    private AgentRepository agentRepository;
    private ArticleRepository articleRepository;


    @Autowired
    public CommandeAgantServiceImpl(CammandeAgentRepository cammandeAgentRepository, AgentRepository agentRepository, ArticleRepository articleRepository, LigneCmdeAgentRepository ligneCmdeAgentRepository) {
        this.cammandeAgentRepository = cammandeAgentRepository;
        this.agentRepository = agentRepository;
        this.articleRepository = articleRepository;
        this.ligneCmdeAgentRepository = ligneCmdeAgentRepository;
    }

    @Override
    public CommandeAgantDto save(CommandeAgantDto commandeAgantDto) {
        List<String> errors = CommandeAgantValidator.validate(commandeAgantDto);

        if (!errors.isEmpty()) {

            log.error("la commande d'Agent nest pas valid");
            throw new InvalidEntityException("la commande d'Agent nest pas valid", ErrorCodes.COMMANDE_AGENT_NOT_VALID);

        }

        Optional<Agent> agent = agentRepository.findById(commandeAgantDto.getAgent().getId());
        if (agent.isEmpty()) {

            log.warn("Agent with ID{} not found on the the DB", commandeAgantDto.getAgent().getId());
            throw new EntityNotFoundException("Aucun Agent avec ID" + commandeAgantDto.getAgent().getId() + "na trouve dans la BD", ErrorCodes.AGENT_NOT_FOUND);

        }

        List<String> articleErrors = new ArrayList<>();

        if (commandeAgantDto.getLigneCmdeAgentDtos() != null) {

            commandeAgantDto.getLigneCmdeAgentDtos().forEach(LignCmdAg -> {

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
        CommandeAgent SavedCmdAgent = cammandeAgentRepository.save(CommandeAgantDto.ToEntity(commandeAgantDto));

        if (commandeAgantDto.getLigneCmdeAgentDtos() != null) {

            commandeAgantDto.getLigneCmdeAgentDtos().forEach(LigCmdAg -> {

                LigneCmdeAgent ligneCmdeAgent = LigneCmdeAgentDto.ToEntity(LigCmdAg);
                ligneCmdeAgent.setCommandeAgent(SavedCmdAgent);
                ligneCmdeAgentRepository.save(ligneCmdeAgent);

            });


        }
        return CommandeAgantDto.FromEntity(SavedCmdAgent);

    }

    @Override
    public CommandeAgantDto findById(Integer id) {


        if (id == null) {

            log.error("Commade Agent IS NULL");
            return null;
        }


        return cammandeAgentRepository.findById(id)
                .map(CommandeAgantDto::FromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("aucun Commande  avec l ID = " + id + "n est pas trouver dans la BDD",
                                ErrorCodes.COMMANDE_AGENT_NOT_FOUND));
    }

    @Override
    public CommandeAgantDto findBycode(String code) {
        if (!StringUtils.hasLength(code)) {

            log.error("Commande Agent CODE is Null");
            return null;
        }

        return cammandeAgentRepository.findCommandeAgentByCode(code)
                .map(CommandeAgantDto::FromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("aucun Commande  de Agent avec le code  = " + code + "n est pas trouver dans la BDD",
                                ErrorCodes.COMMANDE_AGENT_NOT_FOUND));
    }

    @Override
    public List<CommandeAgantDto> findAll() {
        return cammandeAgentRepository.findAll().stream()  /// findAll predifine Function
                .map(CommandeAgantDto::FromEntity)   /// faire le mapping d un Commande Agent  a l autre avec methode refrence FromEntity
                .collect(Collectors.toList());  /// collecter et regreouper dans une list

    }

    @Override
    public void delete(Integer id) {

        if (id == null) {

            log.error("Id of Agent  Is Null");

            return;
        }

        cammandeAgentRepository.deleteById(id);
    }
}
