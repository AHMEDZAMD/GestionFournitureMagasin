package com.aulsh.GestionFournitureMagasin.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ligneCmdeAgents")
public class LigneCmdeAgent extends AbstractEntity{



    @ManyToOne()
    @JoinColumn(name = "idarticle")
    private Article article;


    @ManyToOne()
    @JoinColumn(name = "idcommandeagent")
    private CommandeAgent commandeAgent;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;




}
