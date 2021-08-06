package com.aulsh.GestionFournitureMagasin.DTO;

import com.aulsh.GestionFournitureMagasin.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class UtilisateurDto {
    private  Integer Id;
    private Instant DateNaissance;
    private String emailAdress;

    private String Motdepass;

    private String Nom;
    private String Prenom;
    private String photo;
    private AULSHDto aulsh;
    private List<RolesDto> roles;



    public static UtilisateurDto FromEntiy(Utilisateur utilisateur){

        if (utilisateur == null){

            return null;
        }
        return UtilisateurDto.builder()
                .Id(utilisateur.getId())
                .Nom(utilisateur.getNom())
                .Prenom(utilisateur.getPrenom())
                .Motdepass(utilisateur.getMotdepass())
                .photo(utilisateur.getPhoto())
                .DateNaissance(utilisateur.getDateNaissance())
                .emailAdress(utilisateur.getEmailAdress())
                .build();
    }



    public static Utilisateur ToEntity(UtilisateurDto utilisateurDto){


        if (utilisateurDto == null){

            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMotdepass(utilisateurDto.getMotdepass());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
        utilisateur.setEmailAdress(utilisateurDto.getEmailAdress());

        return utilisateur;
    }
}
