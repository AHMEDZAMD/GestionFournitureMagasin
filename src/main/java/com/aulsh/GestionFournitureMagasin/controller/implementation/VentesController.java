package com.aulsh.GestionFournitureMagasin.controller.implementation;


import com.aulsh.GestionFournitureMagasin.controller.api.VentesApi;
import com.aulsh.GestionFournitureMagasin.DTO.VentesDto;
import com.aulsh.GestionFournitureMagasin.services.VentesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentesController implements VentesApi {

    private VentesService ventesService;

    @Autowired
    public VentesController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return ventesService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    public VentesDto findByCodeVentesDto(String code) {
        return ventesService.findBycodeVentes(code);
    }




    @Override
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        ventesService.delete(id);
    }
}
