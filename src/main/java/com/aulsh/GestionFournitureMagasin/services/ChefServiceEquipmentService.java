package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.ChefServiceEquipmentDto;

import java.util.List;

public interface ChefServiceEquipmentService {


    ChefServiceEquipmentDto save(ChefServiceEquipmentDto chefServiceEquipmentDto);
    ChefServiceEquipmentDto findById(Integer id);
    ChefServiceEquipmentDto findchefByEmail(String emailAdress);

    List<ChefServiceEquipmentDto> findAll();
    void delete(Integer id);
}
