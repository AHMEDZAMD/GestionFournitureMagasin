package com.aulsh.GestionFournitureMagasin.services;

import com.aulsh.GestionFournitureMagasin.DTO.CommandeAgantDto;

import java.util.List;

public interface CommandeAgantService {

    CommandeAgantDto save(CommandeAgantDto commandeAgantDto);

    CommandeAgantDto findById(Integer id);

    CommandeAgantDto findBycode(String Code);


    List<CommandeAgantDto> findAll();

    void delete(Integer id);

}
