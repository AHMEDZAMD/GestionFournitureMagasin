package com.aulsh.GestionFournitureMagasin.services.implementation;


import com.aulsh.GestionFournitureMagasin.DTO.ChefServiceEquipmentDto;
import com.aulsh.GestionFournitureMagasin.exception.EntityNotFoundException;
import com.aulsh.GestionFournitureMagasin.exception.ErrorCodes;
import com.aulsh.GestionFournitureMagasin.exception.InvalidEntityException;
import com.aulsh.GestionFournitureMagasin.model.ChefServiceEquipements;
import com.aulsh.GestionFournitureMagasin.repository.ChefServiceEquipmentRepository;
import com.aulsh.GestionFournitureMagasin.services.ChefServiceEquipmentService;
import com.aulsh.GestionFournitureMagasin.validator.ChefServiceEquipmentValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ChefServiceEquipmentServiceImp implements ChefServiceEquipmentService {


    private ChefServiceEquipmentRepository chefServiceEquipmentRepository;

    @Autowired
    public ChefServiceEquipmentServiceImp(ChefServiceEquipmentRepository chefServiceEquipmentRepository){
        this.chefServiceEquipmentRepository = chefServiceEquipmentRepository;

    }

    @Override
    public ChefServiceEquipmentDto save(ChefServiceEquipmentDto chefServiceEquipmentDto) {
        List<String> errors = ChefServiceEquipmentValidator.validate(chefServiceEquipmentDto);// la validation
        if (!errors.isEmpty()){
            log.error("Chef Service Equipment n'est pas valid {}",chefServiceEquipmentDto);
            throw new InvalidEntityException("Chef Service Equipment n'est pas valid", ErrorCodes.CHEF_SERVICE_EQUIPMENTS_NOT_VALID);

        }

        ChefServiceEquipements SavedChefServiceEqui = chefServiceEquipmentRepository.save(ChefServiceEquipmentDto.ToEntity(chefServiceEquipmentDto));
        return  ChefServiceEquipmentDto.FromEntity(SavedChefServiceEqui);    }

    @Override
    public ChefServiceEquipmentDto findById(Integer id) {


        if (id == null){

            log.error("Agent Id is null ");

            return null;
        }


        return chefServiceEquipmentRepository.findById(id)
                .map(ChefServiceEquipmentDto::FromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun Chef Service Equipment avec l ID = "+id+"n est pas trouver dans la BDD",
                                ErrorCodes.CHEF_SERVICE_EQUIPMENTS_NOT_FOUND));
    }

    @Override
    public ChefServiceEquipmentDto findchefByEmail(String emailAdress) {
        if (!StringUtils.hasLength(emailAdress)){

            log.error("Chef Service Equipment email is Null");
            return null;
        }

        return chefServiceEquipmentRepository.findChefServiceEquipementsByEmailAdress(emailAdress)
                .map(ChefServiceEquipmentDto::FromEntity)
                .orElseThrow(()->
                        new EntityNotFoundException("aucun chef de service equipment avec l email = "+emailAdress+"n est pas trouver dans la BDD",
                                ErrorCodes.CHEF_SERVICE_EQUIPMENTS_NOT_FOUND));
    }

    @Override
    public List<ChefServiceEquipmentDto> findAll() {
            return chefServiceEquipmentRepository.findAll().stream()  /// findAll predifine Function
                    .map(ChefServiceEquipmentDto::FromEntity)   /// faire le mapping d un Chef de Service Equipment a l autre avec methode refrence FromEntity
                    .collect(Collectors.toList());  /// collecter et regreouper dans une list
    }

    @Override
    public void delete(Integer id) {

        if (id == null){

            log.error("Id of chef  service equipment Is Null");

            return;
        }

        chefServiceEquipmentRepository.deleteById(id);

    }
}
