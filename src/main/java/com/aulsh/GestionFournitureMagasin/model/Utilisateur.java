package com.aulsh.GestionFournitureMagasin.model;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity{


    @Column(name = "EmailAdress")
    private String emailAdress;

    @Column(name = "dateNaissance")
    private Instant DateNaissance;

    @Column(name = "Motdepass")
    private String Motdepass;

    @Column(name = "nom")
    private String Nom;

    @Column(name = "photo")
    private String photo;

    @Column(name = "prenom")
    private String Prenom;

    @ManyToOne
    @JoinColumn(name = "idaulsh")
    private  AULSH aulsh;


    @OneToMany(mappedBy = "utilisateur")
    private List<Roles> roles;

}


