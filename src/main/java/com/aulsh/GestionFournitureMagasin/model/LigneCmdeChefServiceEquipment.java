package com.aulsh.GestionFournitureMagasin.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ligneCmdechefServiceequipment")
public class LigneCmdeChefServiceEquipment extends AbstractEntity{


    @Column(name = "IdlignecmdechefserviceEquipment")
    private  Integer Id;

    @ManyToOne()
    @JoinColumn(name = "idarticle")
    private Article article;


    @ManyToOne()
    @JoinColumn(name = "idcmdeChefServiceEquipment")
    private CmdeChefServiceEquipment CmdeChefServiceEquipment;
}


