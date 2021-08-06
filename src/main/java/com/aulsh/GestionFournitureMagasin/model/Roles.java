package com.aulsh.GestionFournitureMagasin.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{


    @Column(name = "Rolename")
    private String RoleName;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
}
