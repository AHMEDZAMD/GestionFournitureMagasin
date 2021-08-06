package com.aulsh.GestionFournitureMagasin.model;
import com.aulsh.GestionFournitureMagasin.DTO.ArticleDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mvstock")
public class MvmStock extends AbstractEntity{


    private SourceMvtStk sourceMvt;


    private TypeMvtStk typeMvt;



    @Column(name = "dateachat")
    private Instant Dateachat;
    @Column(name = "nombreachatpararticl")
    private Integer NombreAchatparArticl;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne()
    @JoinColumn(name = "idarticle")
    private Article article;
}
