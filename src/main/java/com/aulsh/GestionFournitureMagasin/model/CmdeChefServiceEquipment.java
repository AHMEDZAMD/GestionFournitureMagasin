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
@Table(name = "cmdechefserviceequipment")
public class CmdeChefServiceEquipment extends AbstractEntity{


    @Column(name = "code")
    private String code;
    @Column(name = "datecommande")
    private Instant dateCommande;


    @OneToMany(mappedBy = "CmdeChefServiceEquipment")
    private List<LigneCmdeChefServiceEquipment> ligneCmdeChefServiceEquipment;


    @ManyToOne
    @JoinColumn(name = "idchefserviceequipment")
    private ChefServiceEquipements chefServiceEquipements;
}
