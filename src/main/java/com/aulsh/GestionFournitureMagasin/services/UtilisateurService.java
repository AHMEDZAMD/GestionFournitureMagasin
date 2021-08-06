package com.aulsh.GestionFournitureMagasin.services;


import com.aulsh.GestionFournitureMagasin.DTO.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto utilisateurDto);
    UtilisateurDto findById(Integer id);
    UtilisateurDto findByemailUtilisateur(String codeUtilisateur);

    List<UtilisateurDto> findAll();
    void delete(Integer id);
}
