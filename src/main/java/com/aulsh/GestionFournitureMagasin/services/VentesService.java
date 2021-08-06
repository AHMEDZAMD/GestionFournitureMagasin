package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.VentesDto;

import java.util.List;

public interface VentesService {


    VentesDto save(VentesDto dto);
    VentesDto findById(Integer id);
    VentesDto findBycodeVentes(String CodeVentes);

    List<VentesDto> findAll();
    void delete(Integer id);
}
