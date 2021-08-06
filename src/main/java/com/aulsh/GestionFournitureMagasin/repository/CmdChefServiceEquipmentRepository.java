package com.aulsh.GestionFournitureMagasin.repository;

import com.aulsh.GestionFournitureMagasin.model.CmdeChefServiceEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CmdChefServiceEquipmentRepository extends JpaRepository<CmdeChefServiceEquipment,Integer> {


    Optional<CmdeChefServiceEquipment> findCmdeChefServiceEquipmentByCode(String code);

}
