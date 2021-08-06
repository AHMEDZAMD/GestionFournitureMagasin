package com.aulsh.GestionFournitureMagasin.repository;

import com.aulsh.GestionFournitureMagasin.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    Optional<Utilisateur> findUtilisateurByEmailAdress(String EmailAdress);

}
