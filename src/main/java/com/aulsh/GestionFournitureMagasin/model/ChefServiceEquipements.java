package com.aulsh.GestionFournitureMagasin.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
@Table(name = "chefserviceequipements")
public class ChefServiceEquipements extends AbstractEntity{



    @Column(name = "nom")
    private String Nom;
    @Column(name = "prenom")
    private String Prenom;
    @Column(name = "emailadress")
    private String emailAdress;
    @Column(name = "photo")
    private String Photo;
    @Column(name = "numtele")
    private String NumTel;
    @Column(name = "fonction")
    private String Fonction;


    @OneToMany(mappedBy = "chefServiceEquipements")
    private List<CmdeChefServiceEquipment> CmdeChefServiceEquipment;
}
