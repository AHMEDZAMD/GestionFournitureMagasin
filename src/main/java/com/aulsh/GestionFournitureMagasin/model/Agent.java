package com.aulsh.GestionFournitureMagasin.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agent")
public class Agent extends AbstractEntity{



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

    @OneToMany(mappedBy = "agent")
    private List<CommandeAgent> commandeAgents;

}
