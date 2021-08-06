package com.aulsh.GestionFournitureMagasin.model;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "magazin")
public class Magazin extends AbstractEntity {


    @Column(name = "nombretotalearticles")
    private Integer NumbretotalArticles;
    @Column(name = "nomSocial")
    private String  NomSocial;
    @Column(name = "dateCreation")
    private Instant DateCreation;
    @Column(name = "chiffreaffaire")
    private Integer chiffreaffaire;

    @OneToMany(mappedBy = "magazin")
    private List<Article> articles;

}
