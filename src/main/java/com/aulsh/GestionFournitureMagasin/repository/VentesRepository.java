package com.aulsh.GestionFournitureMagasin.repository;

import com.aulsh.GestionFournitureMagasin.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes,Integer> {

    Optional<Ventes> findVentesByCode(String code);
}
