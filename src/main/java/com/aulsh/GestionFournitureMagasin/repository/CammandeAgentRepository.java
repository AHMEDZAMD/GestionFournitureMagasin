package com.aulsh.GestionFournitureMagasin.repository;

import com.aulsh.GestionFournitureMagasin.model.Agent;
import com.aulsh.GestionFournitureMagasin.model.CommandeAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CammandeAgentRepository extends JpaRepository<CommandeAgent,Integer > {


    Optional<CommandeAgent> findCommandeAgentByCode(String code);
}
