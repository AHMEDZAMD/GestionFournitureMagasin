package com.aulsh.GestionFournitureMagasin.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aulsh")
public class AULSH extends AbstractEntity{


   @Column(name = "nom")
    private String Nom;
    @Column(name = "nombreagent")
    private Integer NombreAgent;
    @Column(name = "descreption")
    private String Descprtion;

    @OneToMany(mappedBy = "aulsh")
    private List<Utilisateur> utilisateurs;


}
