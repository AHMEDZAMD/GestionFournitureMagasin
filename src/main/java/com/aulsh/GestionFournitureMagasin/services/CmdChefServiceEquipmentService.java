package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.CmdeChefServiceEquipmentDto;

import java.util.List;

public interface CmdChefServiceEquipmentService {

    CmdeChefServiceEquipmentDto save(CmdeChefServiceEquipmentDto dto);
    CmdeChefServiceEquipmentDto findById(Integer id);
    CmdeChefServiceEquipmentDto findByCmdChefServiceEquipment(String Code);

    List<CmdeChefServiceEquipmentDto> findAll();
    void delete(Integer id);
}
