package com.aulsh.GestionFournitureMagasin.DTO;

import com.aulsh.GestionFournitureMagasin.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

    private  Integer Id;

    private String RoleName;
    private UtilisateurDto utilisateur;



    private static RolesDto FromEntity(Roles roles){

        if (roles == null){
            return null;
        }

        return RolesDto.builder()
                .Id(roles.getId())
                .RoleName(roles.getRoleName())
                .build();
    }


    public static Roles ToEntity(RolesDto rolesDto){

        if ( rolesDto == null){

            return null;
        }


        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setRoleName(rolesDto.getRoleName());


        return roles;
    }

}
