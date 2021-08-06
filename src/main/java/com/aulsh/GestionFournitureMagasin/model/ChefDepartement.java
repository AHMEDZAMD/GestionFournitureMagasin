package com.aulsh.GestionFournitureMagasin.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chefdepartement")
public class ChefDepartement extends AbstractEntity{


    @Column(name = "nom")
    private String Nom;
    @Column(name = "prenom")
    private String Prenom;
    @Column(name = "emailadress")
    private String EmailAdress;
    @Column(name = "photo")
    private String Photo;
    @Column(name = "numtele")
    private String NumTel;
    @Column(name = "fonction")
    private String Fonction;
}
