package com.aulsh.GestionFournitureMagasin.controller.implementation;

import com.aulsh.GestionFournitureMagasin.DTO.CmdeChefServiceEquipmentDto;
import com.aulsh.GestionFournitureMagasin.controller.api.CommandChefServiceEquiApi;
import com.aulsh.GestionFournitureMagasin.services.CmdChefServiceEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandChefServiceEquiController implements CommandChefServiceEquiApi {

    private final CmdChefServiceEquipmentService cmdChefServiceEquipmentService;

    @Autowired

    public CommandChefServiceEquiController(CmdChefServiceEquipmentService cmdChefServiceEquipmentService){

        this.cmdChefServiceEquipmentService = cmdChefServiceEquipmentService;
    }
    @Override
    public CmdeChefServiceEquipmentDto save(CmdeChefServiceEquipmentDto dto) {
        return cmdChefServiceEquipmentService.save(dto);
    }

    @Override
    public CmdeChefServiceEquipmentDto findById(Integer idCmdeChefServiceEquipment) {
        return cmdChefServiceEquipmentService.findById(idCmdeChefServiceEquipment);
    }

    @Override
    public CmdeChefServiceEquipmentDto findByCmdChefServiceEquipment(String codeCmdeChefServiceEquipment) {
        return cmdChefServiceEquipmentService.findByCmdChefServiceEquipment(codeCmdeChefServiceEquipment);
    }

    @Override
    public List<CmdeChefServiceEquipmentDto> findAll() {
        return cmdChefServiceEquipmentService.findAll();
    }

    @Override
    public void delete(Integer id) {
        cmdChefServiceEquipmentService.delete(id);

    }
}
