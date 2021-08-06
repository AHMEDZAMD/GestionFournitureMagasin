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
@Table(name = "article")
public class Article extends AbstractEntity{



    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String Designation;

    @Column(name = "prixunitaire")
    private BigDecimal PrixUnitaire;

    @Column(name = "tauxtva")
    private BigDecimal TauxTva;

    @Column(name = "prixunitairetcc")
    private BigDecimal PrixUnitaireTcc;


    @OneToMany(mappedBy = "article")
    private List<LigneCmdeAgent> ligneCmdeAgents;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "idmagazin")
    private Magazin magazin;


    @OneToMany(mappedBy = "article")
    private List<LigneCmdeChefServiceEquipment> ligneCmdeChefServiceEquipment;



    @OneToMany(mappedBy = "article")
    private List<MvmStock> mvmStocks;
}


