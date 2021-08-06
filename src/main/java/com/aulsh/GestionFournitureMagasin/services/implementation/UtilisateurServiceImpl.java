package com.aulsh.GestionFournitureMagasin.services.implementation;


import com.aulsh.GestionFournitureMagasin.DTO.UtilisateurDto;
import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.Utilisateur;
import com.aulsh.GestionFournitureMagasin.repository.UtilisateurRepository;
import com.aulsh.GestionFournitureMagasin.services.UtilisateurService;
import com.aulsh.GestionFournitureMagasin.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {


    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){

        this.utilisateurRepository= utilisateurRepository;
    }
    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {

        List<String> errors = UtilisateurValidator.validate(utilisateurDto);// la validation
        if (!errors.isEmpty()){
            log.error("Utilisateur n'est pas valid {}",utilisateurDto);
            throw new InvalidEntityException("Utilisateur n'est pas valid", ErrorCodes.UTILISATEUR_NOT_VAILD);

        }

        Utilisateur savedUtilisateur = utilisateurRepository.save(UtilisateurDto.ToEntity(utilisateurDto));
        return  UtilisateurDto.FromEntiy(savedUtilisateur);
    }




    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null){

            log.error("Utilisateur Id is null ");

            return null;
        }


        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::FromEntiy)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Utilisateur avec l ID = "+id+"n est pas trouver dans la BDD",
                                ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public UtilisateurDto findByemailUtilisateur(String emailAdress) {
        if (!StringUtils.hasLength(emailAdress)){

            log.error("Utilisateur Email is Null");
            return null;
        }

        return utilisateurRepository.findUtilisateurByEmailAdress(emailAdress)
                .map(UtilisateurDto::FromEntiy)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Utilisateur avec l EMAIL = "+emailAdress+"n est pas trouver dans la BDD",
                                ErrorCodes.UTILISATEUR_NOT_FOUND));


    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()  /// findAll predifine Function
                .map(UtilisateurDto::FromEntiy)   /// faire le mapping d un Utilisateur a l autre avec methode refrence FromEntity
                .collect(Collectors.toList());  /// collecter et regreouper dans une list////
    }



    @Override
    public void delete(Integer id) {

            if (id == null){

                log.error("Id of Utilisateur Is Null");

                return;
            }

            utilisateurRepository.deleteById(id);
        }


}
