package com.aulsh.GestionFournitureMagasin.repository;

import com.aulsh.GestionFournitureMagasin.model.ChefServiceEquipements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChefServiceEquipmentRepository extends JpaRepository<ChefServiceEquipements,Integer> {

    Optional<ChefServiceEquipements> findChefServiceEquipementsByEmailAdress (String emailAdress);


}
